package oc.webApp.nicolas.actions;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.DetailsOuvrageFault_Exception;
import fr.yogj.bibliows.RechercheOuvrage;
import fr.yogj.bibliows.types.LivreType;
import oc.webApp.nicolas.configurations.BiblioWebAppConfiguration;

/**
 * Classe Action RechercheMultiCritere qui permet de rechercher un livre
 * 
 * @author nicolas
 *
 */
@Service
public class RechercheMultiCritere extends ActionSupport {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private BiblioWebAppConfiguration webAppConfig;
	private String titre;
	private String nomAuteur;
	private String selectedGenre;
	private List<String> listGenre = new ArrayList<String>();
	private List<LivreType> listResultat = new ArrayList<LivreType>();

	/**
	 * Méthode qui construit et envoie les donnees a la jsp
	 * 
	 * @return le resultat de l'action
	 */
	@Override
	public String execute() {
		BiblioWS biblioWS = this.webAppConfig.accesWS();
		logger.debug("recherche multi : titre = " + this.titre + " - auteur = " + this.nomAuteur + " - genre = "
				+ this.selectedGenre);
		this.listGenre.add("ROMAN");
		this.listGenre.add("SCIENCES-FICTION");
		this.listGenre.add("HEROIC-FANTASY");
		RechercheOuvrage parameters = new RechercheOuvrage();
		if (this.titre.length() > 0) {
			parameters.setTitre(this.titre);
		}
		if (this.selectedGenre.length() > 0) {
			parameters.setGenre(this.selectedGenre);
		}
		if (this.nomAuteur.length() > 0) {
			parameters.setAuteurNom(this.nomAuteur);
		}
		try {
			logger.debug(biblioWS.rechercheOuvrage(parameters).getOuvrages().size());
			this.listResultat = biblioWS.rechercheOuvrage(parameters).getOuvrages();
		} catch (DetailsOuvrageFault_Exception e) {
			logger.debug(e.getMessage());
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			return ActionSupport.INPUT;
		} catch (SOAPFaultException e) {
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			logger.debug(e.getMessage());
			return ActionSupport.INPUT;
		}
		return ActionSupport.SUCCESS;
	}

	@Override
	public String input() {
		this.listGenre.add("ROMAN");
		this.listGenre.add("SCIENCES-FICTION");
		this.listGenre.add("HEROIC-FANTASY");
		return ActionSupport.SUCCESS;
	}

	public String getTitre() {
		return this.titre;
	}

	@RequiredStringValidator(message = "Veuillez saisir un titre.")
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getNomAuteur() {
		return this.nomAuteur;
	}

	@RequiredStringValidator(message = "Veuillez saisir un nom d'auteur")
	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	public String getSelectedGenre() {
		return this.selectedGenre;
	}

	public void setSelectedGenre(String selectedGenre) {
		this.selectedGenre = selectedGenre;
	}

	public List<LivreType> getListResultat() {
		return this.listResultat;
	}

	public void setListResultat(List<LivreType> listResultat) {
		this.listResultat = listResultat;
	}

	public List<String> getListGenre() {
		return this.listGenre;
	}

	public void setListGenre(List<String> listGenre) {
		this.listGenre = listGenre;
	}

	public BiblioWebAppConfiguration getWebAppConfig() {
		return this.webAppConfig;
	}

	@Autowired
	public void setWebAppConfig(BiblioWebAppConfiguration webAppConfig) {
		this.webAppConfig = webAppConfig;
	}

}
