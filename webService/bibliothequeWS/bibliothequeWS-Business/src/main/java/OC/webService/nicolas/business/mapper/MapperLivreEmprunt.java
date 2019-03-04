package OC.webService.nicolas.business.mapper;

import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import OC.webService.nicolas.model.entites.CoordonneeUtilisateur;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.UtilisateurType;

/**
 * Classe MapperLivreEmprunt pour mapper les propriétés d'un objet
 * {@link LivreEmpruntType} vers un objet {@link LivreEmprunt} et inversement
 * 
 * @author nicolas
 *
 */

public class MapperLivreEmprunt {

	private static ConversionDate convDate = new ConversionDate();

	/**
	 * Méthode depuis un {@link LivreEmpruntType} vers un {@link LivreEmprunt}
	 * 
	 * @param pLivreEmpruntType
	 * @return {@linkLivreEmprunt}
	 */
	public static LivreEmprunt fromLivreEmpruntTypeToLivreEmprunt(LivreEmpruntType pLivreEmpruntType) {
		Date dateEmprunt = getConvDate().convertirXMLGregorianCalendar(pLivreEmpruntType.getDateEmprunt());
		LivreEmprunt monEmprunt = new LivreEmprunt(dateEmprunt, pLivreEmpruntType.isProlongation());
		monEmprunt.setId(pLivreEmpruntType.getId());
		monEmprunt.setLivre(MapperLivre.fromLivreTypeToLivre(pLivreEmpruntType.getOuvrage()));
		Utilisateur monUser = new Utilisateur(pLivreEmpruntType.getEmprunteur().getNom(),
				pLivreEmpruntType.getEmprunteur().getPrenom(), pLivreEmpruntType.getEmprunteur().getPseudo(),
				pLivreEmpruntType.getEmprunteur().getMotDePasse());
		monUser.setId(pLivreEmpruntType.getEmprunteur().getId());
		for (CoordonneeUtilisateurType cu : pLivreEmpruntType.getEmprunteur().getCoordonnee()) {
			monUser.getCoordonnee().add(MapperCoordonneeUtilisateur.frommCoordonneeTypeToCoordonnee(cu));
		}
		monEmprunt.setUtilisateur(monUser);

		return monEmprunt;

	}

	/**
	 * Méthode depuis un {@link LivreEmprunt} vers un {@link LivreEmpruntType}
	 * 
	 * @param pLivreEmprunt
	 * @return {@link LivreEmpruntType}
	 */
	public static LivreEmpruntType fromLivreEmpruntToLivreEmpruntType(LivreEmprunt pLivreEmprunt) {
		LivreEmpruntType myLet = new LivreEmpruntType();
		myLet.setId(pLivreEmprunt.getId());
		myLet.setProlongation(pLivreEmprunt.isProlongation());
		try {
			myLet.setDateEmprunt(getConvDate().convertirDateXML(pLivreEmprunt.getDateEmprunt()));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		myLet.setOuvrage(MapperLivre.fromLivreToLivreType(pLivreEmprunt.getLivre()));
		UtilisateurType myUserType = new UtilisateurType();
		myUserType.setId(pLivreEmprunt.getUtilisateur().getId());
		myUserType.setNom(pLivreEmprunt.getUtilisateur().getNom());
		myUserType.setPrenom(pLivreEmprunt.getUtilisateur().getPrenom());
		myUserType.setPseudo(pLivreEmprunt.getUtilisateur().getPseudo());
		myUserType.setMotDePasse(pLivreEmprunt.getUtilisateur().getMotDePasse());
		for (CoordonneeUtilisateur cu : pLivreEmprunt.getUtilisateur().getCoordonnee()) {
			myUserType.getCoordonnee().add(MapperCoordonneeUtilisateur.fromCoordoonneeToCoordonneeType(cu));
		}
		myLet.setEmprunteur(myUserType);

		return myLet;
	}

	public static ConversionDate getConvDate() {
		return convDate;
	}

	public static void setConvDate(ConversionDate convDate) {
		MapperLivreEmprunt.convDate = convDate;
	}

}
