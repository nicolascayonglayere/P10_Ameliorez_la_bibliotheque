package OC.webService.nicolas.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.Reservation;
import OC.webService.nicolas.model.entites.Utilisateur;

@Repository
public interface IReservationDao extends JpaRepository<Reservation, Integer> {

	/**
	 * Méthode pour obtenir la liste des {@link Reservation} d'un
	 * {@link Utilisateur} d'id donné en paramètre
	 * 
	 * @param pIdUtilisateur
	 * @return liste des {@link Reservation}
	 */
	public List<Reservation> findByUtilisateurId(int pIdUtilisateur);

	/**
	 * Méthode pour obtenir la liste des {@link Reservation} d'un {@link Livre} d'id
	 * donné en paramètre
	 * 
	 * @param pIdLivre
	 * @return liste des {@link Reservation}
	 */
	public List<Reservation> findByLivreId(int pIdLivre);
}
