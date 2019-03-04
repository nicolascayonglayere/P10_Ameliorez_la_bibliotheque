package OC.webService.nicolas.business.mapper;

import OC.webService.nicolas.model.entites.CoordonneeUtilisateur;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.UtilisateurType;

/**
 * Classe MapperUtilisateur pour mapper les propriétés d'un objet
 * {@link UtilisateurType} vers un objet {@link Utilisateur} et inversement
 * 
 * @author nicolas
 *
 */

public class MapperUtilisateur {

	/**
	 * Méthode depuis un {@link UtilisateurType} vers un {@link Utilisateur}
	 * 
	 * @param pUtilisateurType
	 * @return {@link Utilisateur}
	 */
	public static Utilisateur fromUtilisateurTypeToUtilisateur(UtilisateurType pUtilisateurType) {
		Utilisateur myUser = new Utilisateur(pUtilisateurType.getNom(), pUtilisateurType.getPrenom(),
				pUtilisateurType.getPseudo(), pUtilisateurType.getMotDePasse());
		myUser.setId(pUtilisateurType.getId());
		for (CoordonneeUtilisateurType cut : pUtilisateurType.getCoordonnee()) {
			myUser.getCoordonnee().add(MapperCoordonneeUtilisateur.frommCoordonneeTypeToCoordonnee(cut));
		}
		for (LivreEmpruntType let : pUtilisateurType.getEmprunt()) {
			myUser.getEmprunts().add(MapperLivreEmprunt.fromLivreEmpruntTypeToLivreEmprunt(let));
		}

		return myUser;
	}

	/**
	 * Méthode depuis un {@link Utilisateur} vers un {@link UtilisateurType}
	 * 
	 * @param pUtilisateur
	 * @return {@link UtilisateurType}
	 */
	public static UtilisateurType fromUtilisateurToUtilisateurType(Utilisateur pUtilisateur) {
		UtilisateurType myUt = new UtilisateurType();
		myUt.setId(pUtilisateur.getId());
		myUt.setNom(pUtilisateur.getNom());
		myUt.setPrenom(pUtilisateur.getPrenom());
		myUt.setPseudo(pUtilisateur.getPseudo());
		myUt.setMotDePasse(pUtilisateur.getMotDePasse());
		for (CoordonneeUtilisateur cu : pUtilisateur.getCoordonnee()) {
			myUt.getCoordonnee().add(MapperCoordonneeUtilisateur.fromCoordoonneeToCoordonneeType(cu));
		}
		for (LivreEmprunt le : pUtilisateur.getEmprunts()) {
			myUt.getEmprunt().add(MapperLivreEmprunt.fromLivreEmpruntToLivreEmpruntType(le));
		}

		return myUt;
	}
}
