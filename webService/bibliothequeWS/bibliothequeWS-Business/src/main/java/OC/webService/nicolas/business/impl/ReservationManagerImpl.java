package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.ReservationManager;
import OC.webService.nicolas.business.mapper.MapperReservation;
import OC.webService.nicolas.model.entites.Reservation;
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
			throw new RuntimeException("L'utilisateur n'a pas d'emprunt en cours.");
		}

		return reservationsUtilisateur;
	}

}
