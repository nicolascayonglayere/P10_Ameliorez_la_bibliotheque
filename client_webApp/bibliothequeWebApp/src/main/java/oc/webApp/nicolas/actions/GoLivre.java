package oc.webApp.nicolas.actions;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.DetailsOuvrageFault_Exception;
import fr.yogj.bibliows.RechercheOuvrage;
import fr.yogj.bibliows.RechercheOuvrageResponse;
import fr.yogj.bibliows.types.AuteurType;
import fr.yogj.bibliows.types.LivreType;
import oc.webApp.nicolas.configurations.BiblioWebAppConfiguration;

/**
 * Classe action qui permet d'afficher la page d'un livre
 * 
 * @author nicolas
 *
 */
@Service
public class GoLivre extends ActionSupport {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private BiblioWebAppConfiguration webAppConfig;
	private String idLivre;
	private LivreType livreType = new LivreType();
	private List<AuteurType> auteurs = new ArrayList<AuteurType>();

	/**
	 * Méthode qui construit et envoie les données à la jsp
	 */
	@Override
	public String execute() {
		BiblioWS biblioWS = this.webAppConfig.accesWS();
		RechercheOuvrage param = new RechercheOuvrage();
		logger.debug(this.livreType.getId());
		System.out.println(this.idLivre);
		if (Integer.valueOf(this.idLivre) != 0) {
			param.setIdLivre(Integer.valueOf(this.idLivre));
		} else {
			param.setTitre(this.livreType.getTitre());
			param.setGenre(this.livreType.getGenre());
			param.setAuteurNom(this.livreType.getAuteurs().get(0).getNom());
		}

		try {
			RechercheOuvrageResponse rop = biblioWS.rechercheOuvrage(param);
			this.livreType = rop.getOuvrages().get(0);
			this.auteurs = this.livreType.getAuteurs();
			System.out.println("auteur : " + this.livreType.getAuteurs().get(0).getNom());
			return ActionSupport.SUCCESS;
		} catch (DetailsOuvrageFault_Exception e) {
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			logger.debug(e.getMessage());
			return ActionSupport.INPUT;
		} catch (SOAPFaultException e1) {
			logger.debug(e1.getMessage());
			this.addActionMessage(e1.getMessage());
			e1.printStackTrace();
			return ActionSupport.INPUT;
		}

	}

	public LivreType getLivreType() {
		return this.livreType;
	}

	public void setLivreType(LivreType livreType) {
		this.livreType = livreType;
	}

	public String getIdLivre() {
		return this.idLivre;
	}

	public void setIdLivre(String idLivre) {
		this.idLivre = idLivre;
	}

	public List<AuteurType> getAuteurs() {
		return this.auteurs;
	}

	public void setAuteurs(List<AuteurType> auteurs) {
		this.auteurs = auteurs;
	}

	public BiblioWebAppConfiguration getWebAppConfig() {
		return this.webAppConfig;
	}

	@Autowired
	public void setWebAppConfig(BiblioWebAppConfiguration webAppConfig) {
		this.webAppConfig = webAppConfig;
	}
}
