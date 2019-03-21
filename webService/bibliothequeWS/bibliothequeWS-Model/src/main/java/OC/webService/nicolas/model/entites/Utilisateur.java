package OC.webService.nicolas.model.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entite Hibernate correspondant à la table utilisateur
 * 
 * @author nicolas
 *
 */

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private Integer id;
	@Column(length = 60, nullable = false)
	private String nom;
	@Column(length = 60, nullable = false)
	private String prenom;
	@Column(length = 60, unique = true, nullable = false)
	private String pseudo;
	@Column(name = "mot_de_passe", length = 100, nullable = false)
	private String motDePasse;
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<CoordonneeUtilisateur> coordonnee;
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH })
	private List<LivreEmprunt> emprunts;
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH })
	private List<Reservation> listeAttente;

	/**
	 * Constructeur sans paramètre
	 */
	public Utilisateur() {
	}

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param nom
	 * @param prenom
	 * @param pseudo
	 * @param motDePasse
	 */
	public Utilisateur(String nom, String prenom, String pseudo, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
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
		pLivreEmprunt.setUtilisateur(this);
	}

	public List<Reservation> getListeAttente() {
		return this.listeAttente;
	}

	public void setListeAttente(List<Reservation> listeAttente) {
		this.listeAttente = listeAttente;
	}

	public void addListeAttente(Reservation pReservation) {
		if (this.listeAttente == null) {
			this.listeAttente = new ArrayList<Reservation>();
		}
		this.listeAttente.add(pReservation);
		pReservation.setUtilisateur(this);
	}
}
