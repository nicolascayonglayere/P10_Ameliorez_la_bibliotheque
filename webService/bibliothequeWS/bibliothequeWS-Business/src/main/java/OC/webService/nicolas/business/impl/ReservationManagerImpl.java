package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.ReservationManager;
import OC.webService.nicolas.business.mapper.MapperLivre;
import OC.webService.nicolas.business.mapper.MapperReservation;
import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.Reservation;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.ReservationType;

@Transactional
@Component
public class ReservationManagerImpl extends AbstractManager implements ReservationManager {

	static final Logger logger = LogManager.getLogger();

	@Override
	public List<ReservationType> obtenirReservationsUtilisateur(int pId) throws RuntimeException {
		List<ReservationType> reservationsUtilisateur = new ArrayList<ReservationType>();
		if (this.getDaoFactory().getReservationDAo().findByUtilisateurId(pId).size() > 0) {
			for (Reservation r : this.getDaoFactory().getReservationDAo().findByUtilisateurId(pId)) {
				reservationsUtilisateur.add(MapperReservation.fromReservationToReservationType(r));
			}

		} else {
			throw new RuntimeException("L'utilisateur n'a pas de reservations en cours.");
		}

		return reservationsUtilisateur;
	}

	@Override
	public ReservationType reserverOuvrage(int pIdLivre, int pIdUtilisateur) throws RuntimeException {
		Livre monLivreResa = this.getDaoFactory().getLivreDao().findById(pIdLivre).get();
		if (this.getDaoFactory().getLivreEmpruntDao().findByLivreIdAndUtilisateurId(pIdLivre, pIdUtilisateur) != null) {
			// .getId() > 0) {
			throw new RuntimeException("L'utilisateur a deja emprunte ce livre : " + monLivreResa.getTitre());
		} else if (this.getDaoFactory().getReservationDAo().findByLivreId(pIdLivre)
				.size() == (monLivreResa.getNbExemplaire() * 2)) {
			throw new RuntimeException("La liste d'attente est complete.");
		} else {
			for (Reservation r : this.getDaoFactory().getReservationDAo().findByUtilisateurId(pIdUtilisateur)) {
				if (r.getLivre().getId() == pIdLivre) {
					throw new RuntimeException("L'utilisateur a deja reserve ce livre : " + monLivreResa.getTitre());
				}
			}
			Reservation maResa = new Reservation();
			maResa.setLivre(this.getDaoFactory().getLivreDao().findById(pIdLivre).get());
			maResa.setUtilisateur(this.getDaoFactory().getUtilisateurDao().findById(pIdUtilisateur).get());
			maResa.setDateReservation(Calendar.getInstance().getTime());
			this.getDaoFactory().getReservationDAo().saveAndFlush(maResa);
			return MapperReservation.fromReservationToReservationType(maResa);
		}

	}

	@Override
	public LivreType annulerReservation(int pIdReservation) throws RuntimeException {
		Livre maResaAnnulee = this.getDaoFactory().getLivreDao()
				.findById(this.getDaoFactory().getReservationDAo().findById(pIdReservation).get().getId()).get();
		this.getDaoFactory().getReservationDAo().deleteById(pIdReservation);
		return MapperLivre.fromLivreToLivreType(maResaAnnulee);
	}

}
