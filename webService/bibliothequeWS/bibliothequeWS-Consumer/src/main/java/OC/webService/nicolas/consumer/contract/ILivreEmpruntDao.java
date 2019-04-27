package OC.webService.nicolas.consumer.contract;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;

/**
 * Repository IlivreEmpruntDao concernant {@link LivreEmprunt}
 * 
 * @author nicolas
 *
 */
@Repository
public interface ILivreEmpruntDao extends JpaRepository<LivreEmprunt, Integer> {

	/**
	 * Méthode pour obtenir la liste des {@link LivreEmprunt} à partir de l'id d'un
	 * {@link Livre}
	 * 
	 * @param pId
	 * @return liste de {@link LivreEmprunt}
	 */
	public List<LivreEmprunt> findByLivreId(Integer pId);

	/**
	 * Méthode pour obtenir un {@link LivreEmprunt} à partir de l'id d'un
	 * {@link Livre} et de l'id d'un {@link Utilisateur}
	 * 
	 * @param pIdLivre
	 * @param pIdUtilisateur
	 * @return {@link LivreEmprunt}
	 */
	public LivreEmprunt findByLivreIdAndUtilisateurId(int pIdLivre, int pIdUtilisateur);

	/**
	 * Méthode pour obtenir la liste des {@link Utilisateur} en retard
	 * 
	 * @param pDate
	 * @return liste des {@link Utilisateur}
	 */
	@Query("SELECT u FROM Utilisateur u JOIN FETCH u.coordonnee c JOIN u.emprunts e WHERE e.dateEmprunt <=:date AND u.id = c.utilisateur.id")
	public List<Utilisateur> findRetardataires(@Param("date") Date pDate);

	/**
	 * Méthode pour obtenir la liste des {@link LivreEmprunt} d'un
	 * {@link Utilisateur} d'id donné en paramètre
	 * 
	 * @param pIdUtilisateur
	 * @return liste des {@link LivreEmprunt}
	 */
	public List<LivreEmprunt> findByUtilisateurId(int pIdUtilisateur);

	@Query("SELECT u FROM Utilisateur u JOIN FETCH u.coordonnee c JOIN u.emprunts e WHERE e.dateEmprunt <=:date AND u.rappelOption = :option")
	public List<Utilisateur> findRappelRetour(@Param("option") boolean pOption, @Param("date") Date pDate);

}
