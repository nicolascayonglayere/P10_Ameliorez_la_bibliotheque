package oc.batch.nicolas.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

/**
 * Classe représentant un livre
 * 
 * @author nicolas
 *
 */
@Component
public class Livre {

	private int id;
	private String titre;
	private List<Auteur> auteurs;
	private String genre;
	private XMLGregorianCalendar date;
	private List<Editeur> editeurs;
	private int nbExemplaire;
	private List<LivreEmprunt> emprunts;

	/**
	 * Constructeur sans paramètre
	 */
	public Livre() {
	}

	/**
	 * Constructeur avec paramètre
	 * 
	 * @param id
	 * @param titre
	 * @param genre
	 * @param date
	 * @param nbExemplaire
	 */
	public Livre(int id, String titre, String genre, XMLGregorianCalendar date, int nbExemplaire) {
		this.id = id;
		this.titre = titre;
		this.genre = genre;
		this.date = date;
		this.nbExemplaire = nbExemplaire;
	}

	// --Getter et Setter--
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Auteur> getAuteurs() {
		return this.auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public void addAuteurs(Auteur pAuteur) {
		if (this.auteurs == null) {
			this.auteurs = new ArrayList<Auteur>();
		}
		this.auteurs.add(pAuteur);
		// pAuteur.addManuscrits(this);
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public XMLGregorianCalendar getDate() {
		return this.date;
	}

	public void setDate(XMLGregorianCalendar date) {
		this.date = date;
	}

	public List<Editeur> getEditeurs() {
		return this.editeurs;
	}

	public void setEditeurs(List<Editeur> editeurs) {
		this.editeurs = editeurs;
	}

	public void addEditeurs(Editeur pEditeur) {
		if (this.editeurs == null) {
			this.editeurs = new ArrayList<Editeur>();
		}
		this.editeurs.add(pEditeur);
	}

	public int getNbExemplaire() {
		return this.nbExemplaire;
	}

	public void setNbExemplaire(int nbExemplaire) {
		this.nbExemplaire = nbExemplaire;
	}

	public List<LivreEmprunt> getEmprunts() {
		return this.emprunts;
	}

	public void setEmprunts(List<LivreEmprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public void addEmprunts(LivreEmprunt pLivreEmprunt) {
		if (this.emprunts == null) {
			this.emprunts = new ArrayList<LivreEmprunt>();
		}
		this.emprunts.add(pLivreEmprunt);
		pLivreEmprunt.setOuvrage(this);
	}
}
