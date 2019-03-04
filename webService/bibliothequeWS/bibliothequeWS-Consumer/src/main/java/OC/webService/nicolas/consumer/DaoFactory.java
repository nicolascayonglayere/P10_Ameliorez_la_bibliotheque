package OC.webService.nicolas.consumer;

import OC.webService.nicolas.consumer.contract.ILivreDao;
import OC.webService.nicolas.consumer.contract.ILivreEmpruntDao;
import OC.webService.nicolas.consumer.contract.IUtilisateurDao;

/**
 * Interface DaoFactory qui permet l'accès aux différentes interfaces de la
 * couche consumer
 * 
 * @author nicolas
 *
 */
public interface DaoFactory {

	/**
	 * Méthode d'accès à {@link ILivreDao}
	 * 
	 * @return {@link ILivreDao}
	 */
	ILivreDao getLivreDao();

	/**
	 * Méthode pour définir la {@link ILivreDao}
	 * 
	 * @param livreDao
	 */
	void setLivreDao(ILivreDao livreDao);

	/**
	 * Méthode d'accès à {@link IUtilisateurDao}
	 * 
	 * @return {@link IUtilisateurDao}
	 */
	IUtilisateurDao getUtilisateurDao();

	/**
	 * Méthode pour définir la {@link IUtilisateurDao}
	 * 
	 * @param pUtilisateurDao
	 */
	void setUtilisateurDao(IUtilisateurDao pUtilisateurDao);

	/**
	 * Méthode d'accès à {@link ILivreEmpruntDao}
	 * 
	 * @return {@link ILivreEmpruntDao}
	 */
	ILivreEmpruntDao getLivreEmpruntDao();

	/**
	 * Méthode pour définir la {@link ILivreEmpruntDao}
	 * 
	 * @param pLivreEmpruntDao
	 */
	void setLivreEmpruntDao(ILivreEmpruntDao pLivreEmpruntDao);
}
