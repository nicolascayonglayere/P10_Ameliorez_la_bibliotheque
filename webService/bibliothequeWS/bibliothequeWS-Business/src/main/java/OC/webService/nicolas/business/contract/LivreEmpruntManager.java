package OC.webService.nicolas.business.contract;

import java.util.List;

import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.UtilisateurType;

/**
 * Interface LivreEmpruntManager et ses méthodes de traitement
 * 
 * @author nicolas
 *
 */
public interface LivreEmpruntManager {

	/**
	 * Méthode pour emprunter un {@link Livre} à partir de son id et de l'id de le
	 * {@link Utilisateur}
	 * 
	 * @param pIdLivre
	 * @param pIdEmprunteur
	 * @return {@link LivreEmprunt}
	 * @throws RuntimeException
	 */
	public LivreEmpruntType emprunterOuvrage(int pIdLivre, int pIdEmprunteur) throws RuntimeException;

	/**
	 * Méthode pour rendre un {@link Livre} à partir de l'id de {@link LivreEmprunt}
	 * 
	 * @param pIdEmprunt
	 * @return le {@link Livre} rendu
	 * @throws RuntimeException
	 */
	public LivreType retournerOuvrage(int pIdEmprunt) throws RuntimeException;

	/**
	 * Méthode pour prolonger un {@link LivreEmprunt} d'id donné en paramètre
	 * 
	 * @param pIdEmprunt
	 * @return le {@link LivreEmprunt} prolongé
	 * @throws RuntimeException
	 */
	public LivreEmpruntType prolongerEmprunt(int pIdEmprunt) throws RuntimeException;

	/**
	 * Méthode pour trouver un {@link LivreEmprunt} à partir de son id donné en
	 * paramètre
	 * 
	 * @param pIdEmprunt
	 * @return {@link LivreEmprunt}
	 */
	public LivreEmpruntType findByIdEmprunt(int pIdEmprunt);

	/**
	 * Méthode pour obtenir la liste des {@link Utilisateur} en retard
	 * 
	 * @return liste des {@link Utilisateur}
	 */
	public List<UtilisateurType> obtenirRetardataires();

	/**
	 * Méthode pour trouver la liste des {@link LivreEmprunt} d'un
	 * {@link Utilisateur} d'id donné en paramètre
	 * 
	 * @param pIdUtilisateur
	 * @return la liste de {@link LivreEmprunt}
	 */
	public List<LivreEmpruntType> obtenirEmpruntUtilisateur(int pIdUtilisateur);

	/**
	 * Méthode pour trouver la liste des {@link LivreEmprunt} d'un {@link Livre}
	 * d'id donné en paramètre
	 * 
	 * @param pIdLivre
	 * @return la liste des {@link LivreEmprunt}
	 */
	public List<LivreEmpruntType> obtenirTitreEmprunte(int pIdLivre);

	/**
	 * Méthode pour obtenir la liste des {@link Utilisateur} qui ont coché l'option
	 * de rappel automatique
	 * 
	 * @return la liste des {@link Utilisateur}
	 * 
	 */
	public List<UtilisateurType> obtenirListeRappelRetour();
}
