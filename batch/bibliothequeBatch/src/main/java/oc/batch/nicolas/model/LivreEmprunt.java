package oc.batch.nicolas.model;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

/**
 * Classe représentant un {@link Livre} emprunté
 * 
 * @author nicolas
 *
 */
@Component
public class LivreEmprunt {

	private int id;
	private Utilisateur emprunteur;
	private Livre ouvrage;
	private XMLGregorianCalendar dateEmprunt;
	private boolean prolongation;

	/**
	 * Constructeur sans paramètre
	 */
	public LivreEmprunt() {
	}

	/**
	 * Constructeur avec paramètre
	 * 
	 * @param id
	 * @param dateEmprunt
	 * @param prolongation
	 */
	public LivreEmprunt(int id, XMLGregorianCalendar dateEmprunt, boolean prolongation) {
		this.id = id;
		this.dateEmprunt = dateEmprunt;
		this.prolongation = prolongation;
	}

	// --Getter et Setter--
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utilisateur getEmprunteur() {
		return this.emprunteur;
	}

	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Livre getOuvrage() {
		return this.ouvrage;
	}

	public void setOuvrage(Livre ouvrage) {
		this.ouvrage = ouvrage;
	}

	public XMLGregorianCalendar getDateEmprunt() {
		return this.dateEmprunt;
	}

	public void setDateEmprunt(XMLGregorianCalendar dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public boolean isProlongation() {
		return this.prolongation;
	}

	public void setProlongation(boolean prolongation) {
		this.prolongation = prolongation;
	}

}
