package OC.webService.nicolas.model.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entite Hibernate correspondant à la table livre
 * 
 * @author nicolas
 *
 */

@Entity
@Table(name = "livre")
public class Livre implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livre")
	private Integer id;
	@Column(length = 60)
	private String titre;
	@Column(nullable = false)
	private String genre;
	@Column(name = "date_parution")
	private Date dateParution;
	@Column(name = "nb_exemplaire", nullable = false)
	private int nbExemplaire;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	@JoinTable(name = "livre_manuscrit", joinColumns = @JoinColumn(name = "id_livre"), inverseJoinColumns = @JoinColumn(name = "id_auteur"))
	private List<Auteur> auteurs;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	@JoinTable(name = "livre_edition", joinColumns = @JoinColumn(name = "id_livre"), inverseJoinColumns = @JoinColumn(name = "id_editeur"))
	private List<Editeur> editeurs;
	@OneToMany(mappedBy = "livre", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<LivreEmprunt> emprunts;
	@OneToMany(mappedBy = "livre", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Reservation> listeAttente;

	/**
	 * Constructeur sans paramètre
	 */
	protected Livre() {
	}

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param titre
	 * @param genre
	 * @param dateParution
	 * @param nbExemplaire
	 */
	public Livre(String titre, String genre, Date dateParution, int nbExemplaire) {
		this.titre = titre;
		this.genre = genre;
		this.dateParution = dateParution;
		this.nbExemplaire = nbExemplaire;
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

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getDateParution() {
		return this.dateParution;
	}

	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
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
		pLivreEmprunt.setLivre(this);
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
		pAuteur.addManuscrits(this);
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
		pReservation.setLivre(this);
	}

}
