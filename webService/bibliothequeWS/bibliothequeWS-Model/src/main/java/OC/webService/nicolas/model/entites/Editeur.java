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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "editeur")
public class Editeur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_editeur")
	private Integer id;
	@Column(length = 60, unique = true)
	private String nom;
	@Column(length = 60)
	private String adresse;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	@JoinTable(name = "livre_edition", joinColumns = @JoinColumn(name = "id_editeur"), inverseJoinColumns = @JoinColumn(name = "id_livre"))
	private List<Livre> livreEdites;

	public Editeur() {
	}

	public Editeur(String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
	}

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

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Livre> getLivreEdites() {
		return this.livreEdites;
	}

	public void setLivreEdites(List<Livre> livreEdites) {
		this.livreEdites = livreEdites;
	}

	public void addLivresEdites(Livre pLivre) {
		if (this.livreEdites == null) {
			this.livreEdites = new ArrayList<Livre>();
		}
		this.livreEdites.add(pLivre);
		pLivre.addEditeurs(this);
	}

}
