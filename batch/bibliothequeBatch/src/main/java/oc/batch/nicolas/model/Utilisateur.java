package oc.batch.nicolas.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Classe représentant un utilisateur
 * 
 * @author nicolas
 *
 */
@Component
public class Utilisateur {

	private int id;
	private String nom;
	private String prenom;
	private String pseudo;
	private String motDePasse;
	private List<CoordonneeUtilisateur> coordonnee;
	private List<LivreEmprunt> emprunt;

	/**
	 * Constructeur sans paramètre
	 */
	public Utilisateur() {
	}

	/**
	 * Constructeur avec paramètre
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param pseudo
	 * @param motDePasse
	 */
	public Utilisateur(int id, String nom, String prenom, String pseudo, String motDePasse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
	}

	// --Getter et Setter --
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

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<CoordonneeUtilisateur> getCoordonnee() {
		return this.coordonnee;
	}

	public void setCoordonnee(List<CoordonneeUtilisateur> coordonnee) {
		this.coordonnee = coordonnee;
	}

	public void addCoordonnee(CoordonneeUtilisateur pCoordonnee) {
		if (this.coordonnee == null) {
			this.coordonnee = new ArrayList<CoordonneeUtilisateur>();
		}

		this.coordonnee.add(pCoordonnee);
		pCoordonnee.setUtilisateur(this);
	}

	public List<LivreEmprunt> getEmprunt() {
		return this.emprunt;
	}

	public void setEmprunt(List<LivreEmprunt> emprunt) {
		this.emprunt = emprunt;
	}

	public void addEmprunts(LivreEmprunt pLivreEmprunt) {
		if (this.emprunt == null) {
			this.emprunt = new ArrayList<LivreEmprunt>();
		}
		this.emprunt.add(pLivreEmprunt);
		pLivreEmprunt.setEmprunteur(this);
	}

}
