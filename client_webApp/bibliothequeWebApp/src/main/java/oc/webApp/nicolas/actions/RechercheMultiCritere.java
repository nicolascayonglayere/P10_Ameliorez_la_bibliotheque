package oc.webApp.nicolas.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.DetailsOuvrageFault_Exception;
import fr.yogj.bibliows.ObtenirEmpruntLivreFault;
import fr.yogj.bibliows.RechercheOuvrage;
import fr.yogj.bibliows.types.LivreEmpruntType;
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
	private List<LivreType> listResultatDispo = new ArrayList<LivreType>();
	private Map<LivreType, Map<Date, String>> listResultatResa = new HashMap<LivreType, Map<Date, String>>();

	/**
	 * Méthode qui construit et envoie les donnees a la jsp
	 * 
	 * @return le resultat de l'action
	 */
	@Override
	public String execute() {
		List<LivreType> listResultat = new ArrayList<LivreType>();
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
			listResultat = biblioWS.rechercheOuvrage(parameters).getOuvrages();
			for (LivreType l : listResultat) {
				if (biblioWS.obtenirEmpruntLivre(l.getId()).size() > 0) {
					// --Obtenir la date de retour la plus proche
					List<LivreEmpruntType> vListInt = biblioWS.obtenirEmpruntLivre(l.getId());
					Collections.sort(vListInt, (d1, d2) -> d1.getDateEmprunt().compare(d2.getDateEmprunt()));
					Calendar calTemoin = Calendar.getInstance();
					calTemoin.setTime(vListInt.get(0).getDateEmprunt().toGregorianCalendar().getTime());
					calTemoin.add(Calendar.DAY_OF_MONTH, 28);
					for (LivreEmpruntType let : vListInt) {// --est-ce qu'il parcours dans l'ordre ?
						Calendar cal1 = Calendar.getInstance();
						cal1.setTime(let.getDateEmprunt().toGregorianCalendar().getTime());
						if (let.isProlongation()) {
							cal1.add(Calendar.DAY_OF_MONTH, 28);
						} else {
							cal1.add(Calendar.DAY_OF_MONTH, 28 * 2);
						}

						if (cal1.before(calTemoin)) {
							calTemoin = cal1;
						}
					}

					int nbResa = biblioWS.obtenirReservationOuvrage(l.getId()).size();
					String monStrResa = "";
					if (nbResa > 2 * l.getNbExemplaire()) {
						monStrResa += "A";
					} else {
						monStrResa = String.valueOf(nbResa);
					}
					Map<Date, String> maMapInt = new HashMap<Date, String>();
					maMapInt.put(calTemoin.getTime(), monStrResa);
					this.listResultatResa.put(l, maMapInt);
				} else {
					this.listResultatDispo.add(l);
				}
			}

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
		} catch (ObtenirEmpruntLivreFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public List<LivreType> getListResultatDispo() {
		return this.listResultatDispo;
	}

	public void setListResultatDispo(List<LivreType> listResultatDispo) {
		this.listResultatDispo = listResultatDispo;
	}

	public Map<LivreType, Map<Date, String>> getListResultatResa() {
		return this.listResultatResa;
	}

	public void setListResultatResa(Map<LivreType, Map<Date, String>> listResultatResa) {
		this.listResultatResa = listResultatResa;
	}

}
