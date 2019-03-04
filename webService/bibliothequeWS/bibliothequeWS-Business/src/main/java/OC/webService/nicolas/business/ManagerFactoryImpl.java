package OC.webService.nicolas.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.LivreEmpruntManager;
import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.business.contract.UtilisateurManager;

/**
 * Implémentation de {@link ManagerFactory}
 * 
 * @author nicolas
 *
 */
@Component
public class ManagerFactoryImpl implements ManagerFactory {

	private LivreEmpruntManager lem;
	private LivreManager lm;
	private UtilisateurManager um;

	@Override
	public LivreEmpruntManager getLivreEmpruntManager() {
		return this.lem;
	}

	@Autowired
	@Override
	public void setLivreEmpruntManager(LivreEmpruntManager pLivreEmpruntManager) {
		this.lem = pLivreEmpruntManager;
	}

	@Override
	public LivreManager getLivreManager() {
		return this.lm;
	}

	@Autowired
	@Override
	public void setLivreManager(LivreManager pLivreManager) {
		this.lm = pLivreManager;
	}

	@Override
	public UtilisateurManager getUtilisateurManager() {
		return this.um;
	}

	@Autowired
	@Override
	public void setUtilisateurManager(UtilisateurManager pUtilisateurManager) {
		this.um = pUtilisateurManager;
	}

}
