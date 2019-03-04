package oc.batch.nicolas.model;

import org.springframework.stereotype.Component;

/**
 * Classe représentant les coordonnées postales et email d'un
 * {@link Utilisateur}
 * 
 * @author nicolas
 *
 */
@Component
public class CoordonneeUtilisateur {

	private int id;
	private String adresse;
	private String email;
	private Utilisateur utilisateur;

	/**
	 * Constructeur sans paramètre
	 */
	public CoordonneeUtilisateur() {
	}

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param id
	 * @param adresse
	 * @param email
	 */
	public CoordonneeUtilisateur(int id, String adresse, String email) {
		this.id = id;
		this.adresse = adresse;
		this.email = email;
	}

	// --Getter et Setter--
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
