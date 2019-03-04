package oc.webApp.nicolas.actions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.ListNouveautesResponse;
import fr.yogj.bibliows.types.LivreType;
import oc.webApp.nicolas.configurations.BiblioWebAppConfiguration;

/**
 * Classe Action Accueil peuple la page d'accueil
 * 
 * @author nicolas
 *
 */
@Service
public class Accueil extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<LivreType> livresAccueil = new ArrayList<LivreType>();
	private BiblioWebAppConfiguration webAppConfig;

	/**
	 * Méthode qui construit et envoie les données nécessaires à la jsp
	 */
	@Override
	public String execute() {
		BiblioWS biblioWS = this.webAppConfig.accesWS();
		ListNouveautesResponse lnr = biblioWS.listNouveautes("");

		this.livresAccueil = lnr.getNouveautes();

		return ActionSupport.SUCCESS;
	}

	public List<LivreType> getLivresAccueil() {
		return this.livresAccueil;
	}

	public void setLivresAccueil(List<LivreType> livresAccueil) {
		this.livresAccueil = livresAccueil;
	}

	public BiblioWebAppConfiguration getWebAppConfig() {
		return this.webAppConfig;
	}

	@Autowired
	public void setWebAppConfig(BiblioWebAppConfiguration webAppConfig) {
		this.webAppConfig = webAppConfig;
	}
}
