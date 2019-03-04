package oc.batch.nicolas.model;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Classe représentant l'éditeur
 * 
 * @author nicolas
 *
 */
@Component
public class Editeur {

	private int id;
	private String nom;
	private String adresse;
	private List<Livre> livresEdites;

	/**
	 * Constructeur sans paramètre
	 */
	public Editeur() {
	}

	/**
	 * Constructeur avec paramètre
	 * 
	 * @param id
	 * @param nom
	 * @param adresse
	 */
	public Editeur(int id, String nom, String adresse) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
	}

	// --Getter et Setter--
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

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Livre> getLivresEdites() {
		return this.livresEdites;
	}

	public void setLivresEdites(List<Livre> livresEdites) {
		this.livresEdites = livresEdites;
	}

}
