package OC.webService.nicolas.business.contract;

import java.util.List;
import java.util.Map;

import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.Reservation;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.ReservationType;
import fr.yogj.bibliows.types.UtilisateurType;

public interface ReservationManager {

	/**
	 * Méthode pour trouver la liste des {@link Reservation} d'un
	 * {@link Utilisateur} d'id donné en paramètre
	 * 
	 * @param pId
	 * @return le liste des {@link Reservation}
	 */
	public List<ReservationType> obtenirReservationsUtilisateur(int pId);

	/**
	 * Méthode pour trouver la liste des {@link Reservation} d'un {@link Livre} d'id
	 * donné en paramètre
	 * 
	 * @param pId
	 * @return le liste des {@link Reservation}
	 */
	public List<ReservationType> obtenirReservationsLivre(int pId);

	/**
	 * Méthode pour réserver un {@link Livre} d'id donné en paramètre pour un
	 * {@link Utilisateur} d'id donné en paramètre
	 * 
	 * @param pIdLivre
	 * @param pIdUtilisateur
	 * @return une {@link Reservation}
	 * @throws RuntimeException
	 */
	public ReservationType reserverOuvrage(int pIdLivre, int pIdUtilisateur) throws RuntimeException;

	/**
	 * Méthode pour annuler une {@link Reservation} d'id donné en paramètre
	 * 
	 * @param pIdReservation
	 * @return le {@link Livre} dont la réservation vient d'etre annulee
	 */
	public LivreType annulerReservation(int pIdReservation);

	/**
	 * Méthode pour obtenir la map des {@link Utilisateur} qui ont reservé le
	 * {@link Livre} qui a été retourné (et est donc pret à être emprunte)
	 * 
	 * @returnLa map des {@link Utilisateur} - {@link Livre}
	 */
	public Map<UtilisateurType, LivreType> obtenirListeAlerteRetour();
}
