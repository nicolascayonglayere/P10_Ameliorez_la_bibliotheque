package OC.webService.nicolas.model.entites;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entite Hibernate correspondant à la table coordonnee_utilisateur
 * 
 * @author nicolas
 *
 */
@Entity
@Table(name = "coordonnee_utilisateur")
public class CoordonneeUtilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coordonnee")
	private Integer id;
	@Column(length = 100, nullable = false)
	private String adresse;
	@Column(length = 60, unique = true, nullable = false)
	private String email;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;

	/**
	 * Constructeur sans paramètre
	 */
	public CoordonneeUtilisateur() {
	}

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param adresse
	 * @param email
	 */
	public CoordonneeUtilisateur(String adresse, String email) {
		this.adresse = adresse;
		this.email = email;
	}

	/**
	 * Getter et Setter
	 */
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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
