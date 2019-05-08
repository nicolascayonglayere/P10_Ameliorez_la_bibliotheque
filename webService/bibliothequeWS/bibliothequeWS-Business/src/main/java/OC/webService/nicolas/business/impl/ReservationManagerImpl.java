package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.ReservationManager;
import OC.webService.nicolas.business.mapper.MapperLivre;
import OC.webService.nicolas.business.mapper.MapperReservation;
import OC.webService.nicolas.business.mapper.MapperUtilisateur;
import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.Reservation;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.ReservationType;
import fr.yogj.bibliows.types.UtilisateurType;

/**
 * Implémentation de {@link ReservationManager}
 * 
 * @author nicolas
 *
 */
@Transactional
@Component
public class ReservationManagerImpl extends AbstractManager implements ReservationManager {

	static final Logger logger = LogManager.getLogger();

	/**
	 * Méthode pour obtenir la liste de {@link Reservation} de l {@link Utilisateur}
	 * dont l'id est donné en paramètre
	 */
	@Override
	public List<ReservationType> obtenirReservationsUtilisateur(int pId) {
		List<ReservationType> reservationsUtilisateur = new ArrayList<ReservationType>();
		if (this.getDaoFactory().getReservationDAo().findByUtilisateurId(pId).size() > 0) {
			for (Reservation r : this.getDaoFactory().getReservationDAo().findByUtilisateurId(pId)) {
				reservationsUtilisateur.add(MapperReservation.fromReservationToReservationType(r));
			}

		}
		return reservationsUtilisateur;
	}

	/**
	 * Méthode pour reserver un {@link Livre}
	 */
	@Override
	public ReservationType reserverOuvrage(int pIdLivre, int pIdUtilisateur) throws RuntimeException {
		Livre monLivreResa = this.getDaoFactory().getLivreDao().findById(pIdLivre).get();
		if (this.getDaoFactory().getLivreEmpruntDao().findByLivreIdAndUtilisateurId(pIdLivre, pIdUtilisateur) != null) {
			throw new RuntimeException("L'utilisateur a deja emprunte ce livre : " + monLivreResa.getTitre());
		} else if (this.getDaoFactory().getReservationDAo().findByLivreId(pIdLivre)
				.size() == (monLivreResa.getNbExemplaire() * 2)) {
			throw new RuntimeException("La liste d'attente est complete.");
		} else if (this.getDaoFactory().getLivreEmpruntDao().findByLivreId(pIdLivre).size() < monLivreResa
				.getNbExemplaire()) {
			throw new RuntimeException("Vous pouvez emprunter ce livre : " + monLivreResa.getTitre());
		}

		else {
			for (Reservation r : this.getDaoFactory().getReservationDAo().findByUtilisateurId(pIdUtilisateur)) {
				if (r.getLivre().getId() == pIdLivre) {
					throw new RuntimeException("L'utilisateur a deja reserve ce livre : " + monLivreResa.getTitre());
				}
			}
			Reservation maResa = new Reservation();
			maResa.setLivre(this.getDaoFactory().getLivreDao().findById(pIdLivre).get());
			maResa.setUtilisateur(this.getDaoFactory().getUtilisateurDao().findById(pIdUtilisateur).get());
			maResa.setDateReservation(Calendar.getInstance().getTime());
			this.getDaoFactory().getReservationDAo().saveAndFlush(maResa);
			return MapperReservation.fromReservationToReservationType(maResa);
		}

	}

	/**
	 * Méthode pour annuler une {@link Reservation}
	 */
	@Override
	public LivreType annulerReservation(int pIdReservation) {
		Livre maResaAnnulee = this.getDaoFactory().getReservationDAo().findById(pIdReservation).get().getLivre();
		this.getDaoFactory().getReservationDAo().deleteById(pIdReservation);
		return MapperLivre.fromLivreToLivreType(maResaAnnulee);
	}

	/**
	 * Méthode pour obtenir la liste des {@link Reservation} d'un {@link Livre} dont
	 * l'id est donné en parametre
	 */
	@Override
	public List<ReservationType> obtenirReservationsLivre(int pId) {
		List<ReservationType> reservationsLivre = new ArrayList<ReservationType>();
		if (this.getDaoFactory().getReservationDAo().findByLivreId(pId).size() > 0) {
			for (Reservation r : this.getDaoFactory().getReservationDAo().findByLivreId(pId)) {
				reservationsLivre.add(MapperReservation.fromReservationToReservationType(r));
			}
		}
		return reservationsLivre;
	}

	/**
	 * Méthode pour obtenir la les des {@link Utilisateur} à avertir qu'une de leur
	 * {@link Reservation} est disponible
	 */
	@Override
	public Map<UtilisateurType, LivreType> obtenirListeAlerteRetour() {
		Map<UtilisateurType, LivreType> listeAlerteRetour = new HashMap<UtilisateurType, LivreType>();
		int nbExEnStock = 0;
		List<Reservation> listResa = new ArrayList<Reservation>();

		for (Reservation r : this.getDaoFactory().getReservationDAo().findAll()) {
			if (r.getDateAlerte() == null) {
				nbExEnStock = r.getLivre().getNbExemplaire()
						- this.getDaoFactory().getLivreEmpruntDao().findByLivreId(r.getLivre().getId()).size();
				if (nbExEnStock > 0) {
					listResa.add(r);
				}
			}
		}

		for (Reservation r : listResa) {
			listeAlerteRetour.put(MapperUtilisateur.fromUtilisateurToUtilisateurType(r.getUtilisateur()),
					MapperLivre.fromLivreToLivreType(r.getLivre()));
			r.setDateAlerte(Calendar.getInstance().getTime());
			this.getDaoFactory().getReservationDAo().saveAndFlush(r);
		}

		return listeAlerteRetour;
	}

}
