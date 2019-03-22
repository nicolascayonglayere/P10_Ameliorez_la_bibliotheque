package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.LivreEmpruntManager;
import OC.webService.nicolas.business.mapper.MapperLivre;
import OC.webService.nicolas.business.mapper.MapperLivreEmprunt;
import OC.webService.nicolas.business.mapper.MapperUtilisateur;
import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.UtilisateurType;

/**
 * Implémentation de {@link LivreEmpruntManager}
 * 
 * @author nicolas
 *
 */
@Transactional
@Component
public class LivreEmpruntManagerImpl extends AbstractManager implements LivreEmpruntManager {

	static final Logger logger = LogManager.getLogger();
	private LivreEmprunt livreEmprunt = new LivreEmprunt();

	/**
	 * Méthode pour emprunter un {@link Livre}
	 */
	@Override
	public LivreEmpruntType emprunterOuvrage(int pIdLivre, int pIdEmprunteur) throws RuntimeException {
		Optional<Livre> myOptional = this.getDaoFactory().getLivreDao().findById(pIdLivre);
		Livre l = myOptional.get();
		List<LivreEmprunt> ouvragesEmpruntes = this.getDaoFactory().getLivreEmpruntDao().findByLivreId(pIdLivre);
		int nbEx = l.getNbExemplaire() - ouvragesEmpruntes.size();
		logger.debug("nb exemplaires restants : " + nbEx + " - id : " + l.getId() + " - emprunteur : " + pIdEmprunteur);
		if (nbEx > 0) {

			Optional<Utilisateur> myUserOptional = this.getDaoFactory().getUtilisateurDao().findById(pIdEmprunteur);
			Utilisateur user = myUserOptional.get();
			logger.debug("emprunteur " + user.toString());
			boolean dejaEmprunte = false;
			for (LivreEmprunt le : user.getEmprunts()) {
				if (le.getLivre().getId() == pIdLivre) {
					dejaEmprunte = true;
					break;
				}
			}
			if (!dejaEmprunte) {
				this.livreEmprunt = new LivreEmprunt();
				this.livreEmprunt.setLivre(l);
				this.livreEmprunt.setProlongation(false);
				this.livreEmprunt.setDateEmprunt(Calendar.getInstance().getTime());
				this.livreEmprunt.setUtilisateur(user);
				this.getDaoFactory().getLivreEmpruntDao().saveAndFlush(this.livreEmprunt);
				return MapperLivreEmprunt.fromLivreEmpruntToLivreEmpruntType(this.livreEmprunt);
			} else {
				logger.debug("Erreur : Vous avez deja emprunté ce livre ");
				throw new RuntimeException("Vous avez deja emprunté ce livre : " + this.getDaoFactory()
						.getLivreEmpruntDao().findByLivreIdAndUtilisateurId(pIdLivre, pIdEmprunteur).getId());
			}

		} else

		{
			logger.debug("TRACE");
			// recupérer la date de retour la plus proche
			Calendar cal = Calendar.getInstance();
			Date dateRetour = ouvragesEmpruntes.get(0).getDateEmprunt();
			for (LivreEmprunt le : ouvragesEmpruntes) {
				cal.setTime(le.getDateEmprunt());
				cal.add(Calendar.DATE, 28);
				if (cal.getTime().getTime() > dateRetour.getTime()) {
					dateRetour = cal.getTime();
				}
			}
			logger.debug("Erreur : pas d'exemplaire");
			throw new RuntimeException("Pas d'exemplaire disponible avant " + dateRetour);

		}
	}

	/**
	 * Méthode pour rendre un {@link LivreEmprunt}
	 */
	@Override
	public LivreType retournerOuvrage(int pIdEmprunt) throws RuntimeException {
		Optional<LivreEmprunt> myOptional = this.getDaoFactory().getLivreEmpruntDao().findById(pIdEmprunt);
		this.livreEmprunt = myOptional.get();
		Optional<Livre> myOptionalLivre = this.getDaoFactory().getLivreDao()
				.findById((this.livreEmprunt.getLivre()).getId());
		Livre l = myOptionalLivre.get();
		if (l.getId() != 0) {
			this.getDaoFactory().getLivreEmpruntDao().delete(this.livreEmprunt);
			return MapperLivre.fromLivreToLivreType(l);
		} else {
			throw new RuntimeException("Vous n'avez pas emprunte cet ouvrage.");
		}

	}

	/**
	 * Méthode pour prolonger un {@link LivreEmprunt}
	 */
	@Override
	public LivreEmpruntType prolongerEmprunt(int pIdEmprunt) throws RuntimeException {
		if (this.findByIdEmprunt(pIdEmprunt).getId() != 0) {
			Optional<LivreEmprunt> myOptional = this.getDaoFactory().getLivreEmpruntDao().findById(pIdEmprunt);
			this.livreEmprunt = myOptional.get();
			this.livreEmprunt.setProlongation(true);
			this.livreEmprunt.setDateEmprunt(Calendar.getInstance().getTime());
			this.getDaoFactory().getLivreEmpruntDao().saveAndFlush(this.livreEmprunt);
			return MapperLivreEmprunt.fromLivreEmpruntToLivreEmpruntType(this.livreEmprunt);
		} else {
			throw new RuntimeException("Vous n'avez pas emprunté ce livre.");
		}
	}

	/**
	 * Méthode pour trouver un {@link LivreEmprunt}
	 */
	@Override
	public LivreEmpruntType findByIdEmprunt(int pIdEmprunt) {
		Optional<LivreEmprunt> myOptional = this.getDaoFactory().getLivreEmpruntDao().findById(pIdEmprunt);
		this.livreEmprunt = myOptional.get();
		return MapperLivreEmprunt.fromLivreEmpruntToLivreEmpruntType(this.livreEmprunt);
	}

	/**
	 * Méthode pour obtenir les {@link Utilisateur} en retard
	 */
	@Override
	public List<UtilisateurType> obtenirRetardataires() {
		List<UtilisateurType> retardataires = new ArrayList<UtilisateurType>();
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, -28);
		logger.debug("date emprunt en retard : " + cal.getTime());
		for (Utilisateur u : this.getDaoFactory().getLivreEmpruntDao().findRetardataires(cal.getTime())) {
			logger.debug("taille liste retard : " + u.getEmprunts().size());
			retardataires.add(MapperUtilisateur.fromUtilisateurToUtilisateurType(u));
		}
		return retardataires;
	}

	/**
	 * Méthode pour trouver la liste des {@link LivreEmprunt} d'un
	 * {@link Utilisateur} d'id donné en paramètre
	 */
	@Override
	public List<LivreEmpruntType> obtenirEmpruntUtilisateur(int pIdUtilisateur) throws RuntimeException {
		List<LivreEmpruntType> empruntsUtilisateur = new ArrayList<LivreEmpruntType>();
		if ((this.getDaoFactory().getLivreEmpruntDao().findByUtilisateurId(pIdUtilisateur)).size() > 0) {
			for (LivreEmprunt le : this.getDaoFactory().getLivreEmpruntDao().findByUtilisateurId(pIdUtilisateur)) {
				empruntsUtilisateur.add(MapperLivreEmprunt.fromLivreEmpruntToLivreEmpruntType(le));
			}

		} else {
			throw new RuntimeException("L'utilisateur n'a pas d'emprunt en cours.");
		}
		return empruntsUtilisateur;
	}

	@Override
	public List<LivreEmpruntType> obtenirTitreEmprunte(int pIdLivre) throws RuntimeException {
		System.out.println("Titre emprunte ---------" + pIdLivre);
		List<LivreEmpruntType> titreEmpruntes = new ArrayList<LivreEmpruntType>();
		if ((this.getDaoFactory().getLivreEmpruntDao().findByLivreId(pIdLivre).size()) > 0) {
			for (LivreEmprunt le : this.getDaoFactory().getLivreEmpruntDao().findByLivreId(pIdLivre)) {
				titreEmpruntes.add(MapperLivreEmprunt.fromLivreEmpruntToLivreEmpruntType(le));
			}

		} else {
			throw new RuntimeException("Le titre n'a pas d'emprunt en cours.");
		}
		return titreEmpruntes;
	}
}
