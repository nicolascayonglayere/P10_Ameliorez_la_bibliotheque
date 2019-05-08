package OC.webService.nicolas.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.consumer.contract.ILivreDao;
import OC.webService.nicolas.consumer.contract.ILivreEmpruntDao;
import OC.webService.nicolas.consumer.contract.IReservationDao;
import OC.webService.nicolas.consumer.contract.IUtilisateurDao;

/**
 * Implémentation de {@link DaoFactory}
 * 
 * @author nicolas
 *
 */
@Component
public class DaoFactoryImpl implements DaoFactory {

	private ILivreDao livreDao;
	private IUtilisateurDao userDao;
	private ILivreEmpruntDao livreEmpruntDao;
	private IReservationDao reservationDao;

	@Override
	public ILivreDao getLivreDao() {
		return this.livreDao;
	}

	@Override
	@Autowired
	public void setLivreDao(ILivreDao livreDao) {
		this.livreDao = livreDao;
	}

	@Override
	public IUtilisateurDao getUtilisateurDao() {
		return this.userDao;
	}

	@Autowired
	@Override
	public void setUtilisateurDao(IUtilisateurDao pUtilisateurDao) {
		this.userDao = pUtilisateurDao;

	}

	@Override
	public ILivreEmpruntDao getLivreEmpruntDao() {
		return this.livreEmpruntDao;
	}

	@Autowired
	@Override
	public void setLivreEmpruntDao(ILivreEmpruntDao pLivreEmpruntDao) {
		this.livreEmpruntDao = pLivreEmpruntDao;
	}

	@Override
	public IReservationDao getReservationDAo() {
		return this.reservationDao;
	}

	@Override
	@Autowired
	public void setReservationDao(IReservationDao pReservationDao) {
		this.reservationDao = pReservationDao;

	}
}
