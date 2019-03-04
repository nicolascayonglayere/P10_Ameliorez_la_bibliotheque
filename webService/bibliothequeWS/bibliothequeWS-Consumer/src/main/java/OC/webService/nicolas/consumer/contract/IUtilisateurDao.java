package OC.webService.nicolas.consumer.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.Utilisateur;

/**
 * Repository IUtilisateurDao concernant {@link Utilisateur}
 * 
 * @author nicolas
 *
 */
@Repository
public interface IUtilisateurDao extends JpaRepository<Utilisateur, Integer> {

	/**
	 * Méthode pour obtenir un {@link Utilisateur} à partir de son pseudo et son mot
	 * de passe donné en paramètre
	 * 
	 * @param pseudo
	 * @param motDePasse
	 * @return {@link Utilisateur}
	 */
	public Utilisateur findByPseudo(String pseudo);
}
