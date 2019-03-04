package OC.webService.nicolas.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.Auteur;
import OC.webService.nicolas.model.entites.Livre;

/**
 * Repository ILivreDao concernant les {@link Livre}
 * 
 * @author nicolas
 *
 */
@Repository
public interface ILivreDao extends JpaRepository<Livre, Integer> {

	/**
	 * Méthode pour obtenir une liste de {@link Livre} avec une partie du titre et
	 * du nom de {@link Auteur}
	 * 
	 * @param pTitre
	 * @param pNom
	 * @return liste de {@link Livre}
	 */
	@Query("SELECT l FROM Livre l JOIN FETCH l.auteurs a WHERE l.titre LIKE %:titre% AND a.nom LIKE %:nom%")
	public List<Livre> findByTitreAndAuteurs(@Param("titre") String pTitre, @Param("nom") String pNom);

}
