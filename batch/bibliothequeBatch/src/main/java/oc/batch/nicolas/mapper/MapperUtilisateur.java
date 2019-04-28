package oc.batch.nicolas.mapper;

import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.UtilisateurType;
import oc.batch.nicolas.model.CoordonneeUtilisateur;
import oc.batch.nicolas.model.LivreEmprunt;
import oc.batch.nicolas.model.Utilisateur;

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
		Utilisateur myUser = new Utilisateur(pUtilisateurType.getId(), pUtilisateurType.getNom(),
				pUtilisateurType.getPrenom(), pUtilisateurType.getPseudo(), pUtilisateurType.getMotDePasse());
		myUser.setId(pUtilisateurType.getId());
		myUser.setRappelOption(pUtilisateurType.isRappelOption());
		System.out.println(pUtilisateurType.getCoordonnee().size());
		for (CoordonneeUtilisateurType cut : pUtilisateurType.getCoordonnee()) {
			myUser.addCoordonnee(MapperCoordonneeUtilisateur.frommCoordonneeTypeToCoordonnee(cut));
		}
		for (LivreEmpruntType let : pUtilisateurType.getEmprunt()) {
			myUser.addEmprunts(MapperLivreEmprunt.fromLivreEmpruntTypeToLivreEmprunt(let));
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
		myUt.setRappelOption(pUtilisateur.isRappelOption());
		for (CoordonneeUtilisateur cu : pUtilisateur.getCoordonnee()) {
			myUt.getCoordonnee().add(MapperCoordonneeUtilisateur.fromCoordoonneeToCoordonneeType(cu));
		}
		for (LivreEmprunt le : pUtilisateur.getEmprunt()) {
			myUt.getEmprunt().add(MapperLivreEmprunt.fromLivreEmpruntToLivreEmpruntType(le));
		}

		return myUt;
	}
}
