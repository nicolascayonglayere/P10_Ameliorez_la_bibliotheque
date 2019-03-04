package OC.webService.nicolas.business.mapper;

import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import OC.webService.nicolas.model.entites.Auteur;
import OC.webService.nicolas.model.entites.Livre;
import fr.yogj.bibliows.types.AuteurType;
import fr.yogj.bibliows.types.LivreType;

/**
 * Classe MapperAuteur pour mapper les propriétés d'un objet {@link AuteurType}
 * vers un objet {@link Auteur} et inversement
 * 
 * @author nicolas
 *
 */

public class MapperAuteur {

	private static ConversionDate convDate = new ConversionDate();

	/**
	 * Méthode depuis un {@link Auteur} vers un {@link AuteurType}
	 * 
	 * @param pAuteur
	 * @return {@link AuteurType}
	 */
	public static AuteurType fromAuteurToAuteurType(Auteur pAuteur) {
		AuteurType monType = new AuteurType();
		monType.setId(pAuteur.getId());
		monType.setNationalite(pAuteur.getNationalite());
		monType.setNom(pAuteur.getNom());
		monType.setPrenom(pAuteur.getPrenom());
		try {
			monType.setDateDeNaissance(getConvDate().convertirDateXML(pAuteur.getDateNaissance()));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}

		for (Livre l : pAuteur.getManuscrits()) {
			LivreType lt = MapperLivre.fromLivreToLivreType(l);
			monType.getManuscrits().add(lt);
		}

		return monType;
	}

	/**
	 * Méthode depuis un {@link AuteurType} vers un {@link Auteur}
	 * 
	 * @param pAuteurType
	 * @return {@link Auteur}
	 */
	public static Auteur fromAuteurTypeToAuteur(AuteurType pAuteurType) {
		Date dateNaissance = getConvDate().convertirXMLGregorianCalendar(pAuteurType.getDateDeNaissance());
		Auteur monAuteur = new Auteur(pAuteurType.getNom(), pAuteurType.getPrenom(), dateNaissance,
				pAuteurType.getNationalite());
		monAuteur.setId(pAuteurType.getId());
		for (LivreType lt : pAuteurType.getManuscrits()) {
			Livre l = MapperLivre.fromLivreTypeToLivre(lt);
			monAuteur.getManuscrits().add(l);
		}

		return monAuteur;
	}

	public static ConversionDate getConvDate() {
		return convDate;
	}

	public void setConvDate(ConversionDate convDate) {
		this.convDate = convDate;
	}

}
