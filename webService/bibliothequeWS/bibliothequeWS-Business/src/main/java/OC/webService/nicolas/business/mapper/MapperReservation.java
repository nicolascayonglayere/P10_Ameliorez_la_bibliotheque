package OC.webService.nicolas.business.mapper;

import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import OC.webService.nicolas.model.entites.CoordonneeUtilisateur;
import OC.webService.nicolas.model.entites.Reservation;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.ReservationType;
import fr.yogj.bibliows.types.UtilisateurType;

public class MapperReservation {

	private static ConversionDate convDate = new ConversionDate();

	/**
	 * Méthode depuis un {@link ReservationType} vers une {@link Reservation}
	 * 
	 * @param pReservationType
	 * @return {@link Reservation}
	 */
	public static Reservation fromReservationTypeToReservation(ReservationType pReservationType) {
		Date dateReservation = getConvDate().convertirXMLGregorianCalendar(pReservationType.getDateReservation());
		Reservation maReservation = new Reservation();
		maReservation.setDateReservation(dateReservation);
		maReservation.setLivre(MapperLivre.fromLivreTypeToLivre(pReservationType.getLivre()));
		// maReservation.setId(pReservationType.getId());
		Utilisateur monUser = new Utilisateur(pReservationType.getUtilisateur().getNom(),
				pReservationType.getUtilisateur().getPrenom(), pReservationType.getUtilisateur().getPseudo(),
				pReservationType.getUtilisateur().getMotDePasse());
		monUser.setId(pReservationType.getUtilisateur().getId());
		for (CoordonneeUtilisateurType cu : pReservationType.getUtilisateur().getCoordonnee()) {
			monUser.getCoordonnee().add(MapperCoordonneeUtilisateur.frommCoordonneeTypeToCoordonnee(cu));
		}
		maReservation.setUtilisateur(monUser);

		return maReservation;

	}

	/**
	 * Méthode depuis un {@link Reservation} vers un {@link ReservationType}
	 * 
	 * @param pReservation
	 * @return {@link ReservationType}
	 */
	public static ReservationType fromReservationToReservationType(Reservation pReservation) {
		ReservationType myRt = new ReservationType();
		myRt.setId(pReservation.getId());
		try {
			myRt.setDateReservation(getConvDate().convertirDateXML(pReservation.getDateReservation()));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		myRt.setLivre(MapperLivre.fromLivreToLivreType(pReservation.getLivre()));
		UtilisateurType myUserType = new UtilisateurType();
		myUserType.setId(pReservation.getUtilisateur().getId());
		myUserType.setNom(pReservation.getUtilisateur().getNom());
		myUserType.setPrenom(pReservation.getUtilisateur().getPrenom());
		myUserType.setPseudo(pReservation.getUtilisateur().getPseudo());
		myUserType.setMotDePasse(pReservation.getUtilisateur().getMotDePasse());
		for (CoordonneeUtilisateur cu : pReservation.getUtilisateur().getCoordonnee()) {
			myUserType.getCoordonnee().add(MapperCoordonneeUtilisateur.fromCoordoonneeToCoordonneeType(cu));
		}
		myRt.setUtilisateur(myUserType);

		return myRt;
	}

	public static ConversionDate getConvDate() {
		return convDate;
	}

	public static void setConvDate(ConversionDate convDate) {
		MapperReservation.convDate = convDate;
	}

}
