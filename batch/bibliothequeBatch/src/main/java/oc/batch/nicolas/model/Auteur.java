package oc.batch.nicolas.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

/**
 * Classe representant un auteur
 * 
 * @author nicolas
 *
 */
@Component
public class Auteur {

	private int id;
	private String nom;
	private String prenom;
	private XMLGregorianCalendar dateDeNaissance;
	private String nationalite;
	private List<Livre> manuscrits;

	/**
	 * Constructeur sans paramètre
	 */
	public Auteur() {
	}

	/**
	 * Constructeur avec paramètre
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param nationalite
	 */
	public Auteur(int id, String nom, String prenom, XMLGregorianCalendar dateDeNaissance, String nationalite) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.nationalite = nationalite;
	}

	// -- Getter et Setter--
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public XMLGregorianCalendar getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(XMLGregorianCalendar dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNationalite() {
		return this.nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public List<Livre> getManuscrits() {
		return this.manuscrits;
	}

	public void setManuscrits(List<Livre> manuscrits) {
		this.manuscrits = manuscrits;
	}

	public void addManuscrits(Livre pManuscrit) {
		if (this.manuscrits == null) {
			this.manuscrits = new ArrayList<Livre>();
		}
		this.manuscrits.add(pManuscrit);
		pManuscrit.addAuteurs(this);
	}
}
