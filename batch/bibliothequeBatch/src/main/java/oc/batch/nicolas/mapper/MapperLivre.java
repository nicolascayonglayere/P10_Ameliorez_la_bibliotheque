package oc.batch.nicolas.mapper;

import javax.xml.datatype.XMLGregorianCalendar;

import fr.yogj.bibliows.types.AuteurType;
import fr.yogj.bibliows.types.LivreType;
import oc.batch.nicolas.model.Auteur;
import oc.batch.nicolas.model.Livre;

/**
 * Classe MapperLivre pour mapper les propriétés d'un objet {@link LivreType}
 * vers un objet {@link Livre} et inversement
 * 
 * @author nicolas
 *
 */

public class MapperLivre {

	/**
	 * Méthode depuis {@link LivreType} vers un {@link Livre}
	 * 
	 * @param pLivreType
	 * @return {@link Livre}
	 */
	public static Livre fromLivreTypeToLivre(LivreType pLivreType) {
		XMLGregorianCalendar dateParution = pLivreType.getDate();
		Livre monLivre = new Livre(pLivreType.getId(), pLivreType.getTitre(), pLivreType.getGenre(), dateParution,
				pLivreType.getNbExemplaire());
		monLivre.setId(pLivreType.getId());
		for (AuteurType at : pLivreType.getAuteurs()) {
			XMLGregorianCalendar dateNaissance = at.getDateDeNaissance();
			Auteur monAuteur = new Auteur(at.getId(), at.getNom(), at.getPrenom(), dateNaissance, at.getNationalite());
			monAuteur.setId(at.getId());
			monLivre.addAuteurs(monAuteur);
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
		lt.setDate(pLivre.getDate());
		for (Auteur a : pLivre.getAuteurs()) {
			AuteurType au = new AuteurType();
			au.setId(a.getId());
			au.setNom(a.getNom());
			au.setPrenom(a.getPrenom());
			au.setNationalite(a.getNationalite());
			au.setDateDeNaissance((a.getDateDeNaissance()));
			lt.getAuteurs().add(au);
		}
		return lt;
	}

}
