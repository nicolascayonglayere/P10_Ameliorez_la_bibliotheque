package OC.webService.nicolas.model.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entite Hibernate correspondant à la table livre_emprunt
 * 
 * @author nicolas
 *
 */

@Entity
@Table(name = "livre_emprunt")
public class LivreEmprunt implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_emprunt")
	private Integer id;
	@Column(name = "date_emprunt", nullable = false)
	private Date dateEmprunt;
	@Column(nullable = false)
	private boolean prolongation;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_livre")
	private Livre livre;

	/**
	 * Constructeur sans paramètre
	 */
	public LivreEmprunt() {
	}

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param dateEmprunt
	 * @param prolongation
	 */
	public LivreEmprunt(Date dateEmprunt, boolean prolongation) {
		this.dateEmprunt = dateEmprunt;
		this.prolongation = prolongation;
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

	public Date getDateEmprunt() {
		return this.dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public boolean isProlongation() {
		return this.prolongation;
	}

	public void setProlongation(boolean prolongation) {
		this.prolongation = prolongation;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Livre getLivre() {
		return this.livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

}
