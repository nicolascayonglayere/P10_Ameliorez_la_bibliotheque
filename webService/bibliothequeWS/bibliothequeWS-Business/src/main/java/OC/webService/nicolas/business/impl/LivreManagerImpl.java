package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.business.mapper.MapperLivre;
import OC.webService.nicolas.model.entites.Auteur;
import OC.webService.nicolas.model.entites.Livre;
import fr.yogj.bibliows.types.LivreType;

/**
 * Implémentation de {@link LivreManager}
 * 
 * @author nicolas
 *
 */
@Transactional
@Component
public class LivreManagerImpl extends AbstractManager implements LivreManager {

	static final Logger logger = LogManager.getLogger();
	private List<Livre> livres = new ArrayList<Livre>();

	/**
	 * Méthode pour obtenir les 6 derniers {@link Livre} inscrits en bdd
	 */
	@Override
	public List<LivreType> obtenirNouveautes() {
		List<LivreType> nouveautes = new ArrayList<LivreType>();
		this.livres = this.getDaoFactory().getLivreDao().findAll();
		ListIterator<Livre> livresIterator = this.livres.listIterator(this.livres.size());
		while (livresIterator.hasPrevious()) {
			nouveautes.add(MapperLivre.fromLivreToLivreType(livresIterator.previous()));
		}
		return nouveautes;
	}

	/**
	 * Méthode pour trouver un {@link Livre} à partir de son titre et du nom de son
	 * {@link Auteur} donné en paramètres
	 */
	@Override
	public List<LivreType> trouverParTitreEtAuteur(String pTitre, String pNom) throws RuntimeException {
		logger.debug(pTitre + pNom);
		System.out.println(pTitre + pNom);
		List<LivreType> livresTrouves = new ArrayList<LivreType>();
		if (this.getDaoFactory().getLivreDao().findByTitreAndAuteurs(pTitre, pNom).size() > 0) {
			this.livres = this.getDaoFactory().getLivreDao().findByTitreAndAuteurs(pTitre, pNom);
			for (Livre l : this.livres) {
				livresTrouves.add(MapperLivre.fromLivreToLivreType(l));
			}
		} else {
			throw new RuntimeException("ouvrage non trouvé : titre = " + pTitre + " - auteur = " + pNom);
		}

		return livresTrouves;
	}

	/**
	 * Méthode pour trouver un {@link Livre} à partir de son id donné en paramètre
	 */
	@Override
	public LivreType trouverParId(Integer id) {
		Optional<Livre> monOption = this.getDaoFactory().getLivreDao().findById(id);
		return MapperLivre.fromLivreToLivreType(monOption.get());
	}
}
