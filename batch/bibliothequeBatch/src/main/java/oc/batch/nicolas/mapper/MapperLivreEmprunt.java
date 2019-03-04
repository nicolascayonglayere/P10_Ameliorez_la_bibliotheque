package oc.batch.nicolas.mapper;

import javax.xml.datatype.XMLGregorianCalendar;

import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.UtilisateurType;
import oc.batch.nicolas.model.CoordonneeUtilisateur;
import oc.batch.nicolas.model.LivreEmprunt;
import oc.batch.nicolas.model.Utilisateur;

/**
 * Classe MapperLivreEmprunt pour mapper les propriétés d'un objet
 * {@link LivreEmpruntType} vers un objet {@link LivreEmprunt} et inversement
 * 
 * @author nicolas
 *
 */

public class MapperLivreEmprunt {

	/**
	 * Méthode depuis un {@link LivreEmpruntType} vers un {@link LivreEmprunt}
	 * 
	 * @param pLivreEmpruntType
	 * @return {@link LivreEmprunt}
	 */
	public static LivreEmprunt fromLivreEmpruntTypeToLivreEmprunt(LivreEmpruntType pLivreEmpruntType) {
		XMLGregorianCalendar dateEmprunt = pLivreEmpruntType.getDateEmprunt();
		LivreEmprunt monEmprunt = new LivreEmprunt(pLivreEmpruntType.getId(), dateEmprunt,
				pLivreEmpruntType.isProlongation());
		monEmprunt.setId(pLivreEmpruntType.getId());
		monEmprunt.setOuvrage(MapperLivre.fromLivreTypeToLivre(pLivreEmpruntType.getOuvrage()));
		Utilisateur monUser = new Utilisateur(pLivreEmpruntType.getEmprunteur().getId(),
				pLivreEmpruntType.getEmprunteur().getNom(), pLivreEmpruntType.getEmprunteur().getPrenom(),
				pLivreEmpruntType.getEmprunteur().getPseudo(), pLivreEmpruntType.getEmprunteur().getMotDePasse());
		monUser.setId(pLivreEmpruntType.getEmprunteur().getId());
		for (CoordonneeUtilisateurType cu : pLivreEmpruntType.getEmprunteur().getCoordonnee()) {
			monUser.addCoordonnee(MapperCoordonneeUtilisateur.frommCoordonneeTypeToCoordonnee(cu));
		}
		monEmprunt.setEmprunteur(monUser);

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
		myLet.setDateEmprunt(pLivreEmprunt.getDateEmprunt());
		myLet.setOuvrage(MapperLivre.fromLivreToLivreType(pLivreEmprunt.getOuvrage()));
		UtilisateurType myUserType = new UtilisateurType();
		myUserType.setId(pLivreEmprunt.getEmprunteur().getId());
		myUserType.setNom(pLivreEmprunt.getEmprunteur().getNom());
		myUserType.setPrenom(pLivreEmprunt.getEmprunteur().getPrenom());
		myUserType.setPseudo(pLivreEmprunt.getEmprunteur().getPseudo());
		myUserType.setMotDePasse(pLivreEmprunt.getEmprunteur().getMotDePasse());
		for (CoordonneeUtilisateur cu : pLivreEmprunt.getEmprunteur().getCoordonnee()) {
			myUserType.getCoordonnee().add(MapperCoordonneeUtilisateur.fromCoordoonneeToCoordonneeType(cu));
		}
		myLet.setEmprunteur(myUserType);

		return myLet;
	}

}
