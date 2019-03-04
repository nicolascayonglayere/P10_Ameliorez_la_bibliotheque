package OC.webService.nicolas.business.mapper;

import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import OC.webService.nicolas.model.entites.Auteur;
import OC.webService.nicolas.model.entites.Livre;
import fr.yogj.bibliows.types.AuteurType;
import fr.yogj.bibliows.types.LivreType;

/**
 * Classe MapperLivre pour mapper les propriétés d'un objet {@link LivreType}
 * vers un objet {@link Livre} et inversement
 * 
 * @author nicolas
 *
 */

public class MapperLivre {

	private static ConversionDate convDate = new ConversionDate();

	/**
	 * Méthode depuis {@link LivreType} vers un {@link Livre}
	 * 
	 * @param pLivreType
	 * @return {@link Livre}
	 */
	public static Livre fromLivreTypeToLivre(LivreType pLivreType) {
		Date dateParution = getConvDate().convertirXMLGregorianCalendar(pLivreType.getDate());
		Livre monLivre = new Livre(pLivreType.getTitre(), pLivreType.getGenre(), dateParution,
				pLivreType.getNbExemplaire());
		monLivre.setId(pLivreType.getId());
		for (AuteurType at : pLivreType.getAuteurs()) {
			Date dateNaissance = getConvDate().convertirXMLGregorianCalendar(at.getDateDeNaissance());
			Auteur monAuteur = new Auteur(at.getNom(), at.getPrenom(), dateNaissance, at.getNationalite());
			monAuteur.setId(at.getId());
			monLivre.getAuteurs().add(monAuteur);
		}

		return monLivre;
	}

	/**
	 * Méthode depuis {@link Livre} vers un {@link LivreType}
	 * 
	 * @param pLivre
	 * @return {@link LivreType}
	 */
	public static LivreType fromLivreToLivreType(Livre pLivre) {
		LivreType lt = new LivreType();
		lt.setId(pLivre.getId());
		lt.setTitre(pLivre.getTitre());
		lt.setGenre(pLivre.getGenre());
		lt.setNbExemplaire(pLivre.getNbExemplaire());
		try {
			lt.setDate(getConvDate().convertirDateXML(pLivre.getDateParution()));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		for (Auteur a : pLivre.getAuteurs()) {
			AuteurType au = new AuteurType();
			au.setId(a.getId());
			au.setNom(a.getNom());
			au.setPrenom(a.getPrenom());
			au.setNationalite(a.getNationalite());
			try {
				au.setDateDeNaissance(getConvDate().convertirDateXML(a.getDateNaissance()));
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
			lt.getAuteurs().add(au);
		}
		return lt;
	}

	public static ConversionDate getConvDate() {
		return convDate;
	}

	public static void setConvDate(ConversionDate convDate) {
		MapperLivre.convDate = convDate;
	}
}
