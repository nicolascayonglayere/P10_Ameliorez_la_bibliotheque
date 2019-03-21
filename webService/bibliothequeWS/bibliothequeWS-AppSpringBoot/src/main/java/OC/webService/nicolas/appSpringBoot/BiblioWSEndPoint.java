package OC.webService.nicolas.appSpringBoot;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import OC.webService.nicolas.business.ManagerFactory;
import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.Deconnexion;
import fr.yogj.bibliows.DeconnexionFault_Exception;
import fr.yogj.bibliows.DetailsOuvrageFault_Exception;
import fr.yogj.bibliows.EmpruntOuvrageFault_Exception;
import fr.yogj.bibliows.ListNouveautesResponse;
import fr.yogj.bibliows.ListRetardatairesResponse;
import fr.yogj.bibliows.LoginFault_Exception;
import fr.yogj.bibliows.ObtenirEmpruntUtilisateurFault_Exception;
import fr.yogj.bibliows.ObtenirReservationUtilisateurFault_Exception;
import fr.yogj.bibliows.ProlongationOuvrageFault1_Exception;
import fr.yogj.bibliows.RechercheOuvrage;
import fr.yogj.bibliows.RechercheOuvrageResponse;
import fr.yogj.bibliows.RetourOuvrageFault1_Exception;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.ReservationType;
import fr.yogj.bibliows.types.UtilisateurType;

/**
 * Classe BiblioWSEndPoint implémentation de {@link BiblioWS}
 * 
 * @author nicolas
 *
 */

public class BiblioWSEndPoint implements BiblioWS {// implements BiblioWS {

	static final Logger logger = LogManager.getLogger();

	private ManagerFactory manageFacto;

	/**
	 * Méthode pour authentifier un {@link Utilisateur} à partir de son pseudo et de
	 * son mot de passe donnés en paramètre
	 */
	@Override
	public UtilisateurType login(String pseudo) throws LoginFault_Exception {
		try {
			UtilisateurType user = this.manageFacto.getUtilisateurManager().getUtilisateur(pseudo);
			return user;
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			throw new LoginFault_Exception(e.getMessage());
		}
	}

	/**
	 * Méthode pour obtenir la liste de {@link Livre} nouveau
	 */
	@Override
	public ListNouveautesResponse listNouveautes(String parameters) {
		ListNouveautesResponse nouveautes = new ListNouveautesResponse();

		for (LivreType l : this.manageFacto.getLivreManager().obtenirNouveautes()) {
			nouveautes.getNouveautes().add(l);
		}
		return nouveautes;
	}

	/**
	 * Méthode pour obtenir la liste des {@link Utilisateur} en retard
	 */
	@Override
	public ListRetardatairesResponse listRetardataires(String parameters) {
		ListRetardatairesResponse lrr = new ListRetardatairesResponse();
		for (UtilisateurType u : this.manageFacto.getLivreEmpruntManager().obtenirRetardataires()) {
			lrr.getUtilisateur().add(u);
		}
		return lrr;
	}

	/**
	 * Méthode pour chercher un {@link Livre}
	 */
	@Override
	public RechercheOuvrageResponse rechercheOuvrage(RechercheOuvrage parameters) throws DetailsOuvrageFault_Exception {
		RechercheOuvrageResponse rop = new RechercheOuvrageResponse();
		System.out.println(parameters.getIdLivre());
		try {
			if (parameters.getIdLivre() != null && parameters.getIdLivre() != 0) {
				LivreType livre = this.manageFacto.getLivreManager().trouverParId(parameters.getIdLivre());
				rop.getOuvrages().add(livre);
			} else {
				List<LivreType> livres = this.manageFacto.getLivreManager()
						.trouverParTitreEtAuteur(parameters.getTitre(), parameters.getAuteurNom());
				for (LivreType l : livres) {
					rop.getOuvrages().add(l);
				}
			}
			return rop;
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
			throw new DetailsOuvrageFault_Exception(e.getMessage());
		}
	}

	/**
	 * Méthode pour prolonger un {@link LivreEmprunt}
	 */
	@Override
	public LivreEmpruntType prolongationOuvrage(int idEmprunt) throws ProlongationOuvrageFault1_Exception {
		try {
			LivreEmpruntType livreEmprunte = this.manageFacto.getLivreEmpruntManager().prolongerEmprunt(idEmprunt);
			return livreEmprunte;
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			throw new ProlongationOuvrageFault1_Exception(e.getMessage());
		}
	}

	/**
	 * Méthode pour déconnecter un {@link Utilisateur}
	 */
	@Override
	public String deconnexion(Deconnexion parameters) throws DeconnexionFault_Exception {
		try {
			this.manageFacto.getUtilisateurManager().getUtilisateur(parameters.getId());
			return "DECO OK";
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			throw new DeconnexionFault_Exception("Erreur lors de la deconnexion");
		}
	}

	/**
	 * Méthode pour emprunter un {@link Livre}
	 */
	@Override
	public LivreEmpruntType empruntOuvrage(int idLivre, int idEmprunteur) throws EmpruntOuvrageFault_Exception {
		try {
			LivreEmpruntType empruntType = this.manageFacto.getLivreEmpruntManager().emprunterOuvrage(idLivre,
					idEmprunteur);
			return empruntType;
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			throw new EmpruntOuvrageFault_Exception(e.getMessage());
		}

	}

	/**
	 * Méthode pour obtenir la liste des {@link LivreEmprunt} d'un
	 * {@link Utilisateur} d'id donné en paramètre
	 */
	@Override
	public List<LivreEmpruntType> obtenirEmpruntUtilisateur(int idUtilisateur)
			throws ObtenirEmpruntUtilisateurFault_Exception {

		try {
			List<LivreEmpruntType> livresEmpruntes = this.manageFacto.getLivreEmpruntManager()
					.obtenirEmpruntUtilisateur(idUtilisateur);
			return livresEmpruntes;

		} catch (RuntimeException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new ObtenirEmpruntUtilisateurFault_Exception(e.getMessage());
		}

	}

	/**
	 * Méthode pour rendre un {@link LivreEmprunt} dont l'id est donné en paramètre
	 */
	@Override
	public LivreType retourOuvrage(int idLivreEmprunt) throws RetourOuvrageFault1_Exception {
		try {
			LivreType livreEmprunte = this.manageFacto.getLivreEmpruntManager().retournerOuvrage(idLivreEmprunt);
			return livreEmprunte;
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			throw new RetourOuvrageFault1_Exception(e.getMessage());
		}

	}

	@Override
	public List<ReservationType> obtenirReservationUtilisateur(int idUtilisateur)
			throws ObtenirReservationUtilisateurFault_Exception {
		try {
			List<ReservationType> reservations = this.manageFacto.getReservationManager()
					.obtenirReservationsUtilisateur(idUtilisateur);
			return reservations;

		} catch (RuntimeException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new ObtenirReservationUtilisateurFault_Exception(e.getMessage());
		}
	}

	public ManagerFactory getManageFacto() {
		return this.manageFacto;
	}

	@Autowired
	public void setManageFacto(ManagerFactory manageFacto) {
		this.manageFacto = manageFacto;
	}

}
