package oc.batch.nicolas.mapper;

import javax.xml.datatype.XMLGregorianCalendar;

import fr.yogj.bibliows.types.AuteurType;
import fr.yogj.bibliows.types.LivreType;
import oc.batch.nicolas.model.Auteur;
import oc.batch.nicolas.model.Livre;

/**
 * Classe MapperAuteur pour mapper les propriétés d'un objet {@link AuteurType}
 * vers un objet {@link Auteur} et inversement
 * 
 * @author nicolas
 *
 */

public class MapperAuteur {

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
		monType.setDateDeNaissance(pAuteur.getDateDeNaissance());

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
		XMLGregorianCalendar dateNaissance = pAuteurType.getDateDeNaissance();
		Auteur monAuteur = new Auteur(pAuteurType.getId(), pAuteurType.getNom(), pAuteurType.getPrenom(), dateNaissance,
				pAuteurType.getNationalite());
		monAuteur.setId(pAuteurType.getId());
		for (LivreType lt : pAuteurType.getManuscrits()) {
			Livre l = MapperLivre.fromLivreTypeToLivre(lt);
			monAuteur.getManuscrits().add(l);
		}

		return monAuteur;
	}

}
