package OC.webService.nicolas.business;

import OC.webService.nicolas.business.contract.LivreEmpruntManager;
import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.business.contract.UtilisateurManager;

/**
 * Interface ManagerFactory qui permet l'accès aux différentes interfaces de la
 * couche business
 * 
 * @author nicolas
 *
 */
public interface ManagerFactory {

	/**
	 * Méthode d'accès à {@link LivreEmpruntManager}
	 * 
	 * @return {@link LivreEmpruntManager}
	 */
	LivreEmpruntManager getLivreEmpruntManager();

	/**
	 * Méthode pour définir le {@link LivreEmpruntManager}
	 * 
	 * @param pLivreEmpruntManager
	 */
	void setLivreEmpruntManager(LivreEmpruntManager pLivreEmpruntManager);

	/**
	 * Méthode d'accès à {@linkLivreManager}
	 * 
	 * @return {@linkLivreManager}
	 */
	LivreManager getLivreManager();

	/**
	 * Méthode pour définir le {@linkLivreManager}
	 * 
	 * @param pLivreManager
	 */
	void setLivreManager(LivreManager pLivreManager);

	/**
	 * Méthode d'accès à {@link UtilisateurManager}
	 * 
	 * @return {@link UtilisateurManager}
	 */
	UtilisateurManager getUtilisateurManager();

	/**
	 * Méthode pour définir le {@link UtilisateurManager}
	 * 
	 * @param pUtilisateurManager
	 */
	void setUtilisateurManager(UtilisateurManager pUtilisateurManager);
}
