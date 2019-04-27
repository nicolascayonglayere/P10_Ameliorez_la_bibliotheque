package oc.webApp.nicolas.actions;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.ObtenirEmpruntLivreFault;
import fr.yogj.bibliows.ObtenirEmpruntUtilisateurFault_Exception;
import fr.yogj.bibliows.ObtenirReservationUtilisateurFault_Exception;
import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.ReservationType;
import fr.yogj.bibliows.types.UtilisateurType;
import oc.webApp.nicolas.configurations.BiblioWebAppConfiguration;

/**
 * Classe Action MonCompte qui permet la construction de la jsp monCompte
 * 
 * @author nicolas
 *
 */
@Service
public class MonCompte extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private BiblioWebAppConfiguration webAppConfig;
	private Map<String, Object> session;
	private UtilisateurType utilisateur;
	private Map<LivreEmpruntType, Date> listEmprunt = new HashMap<LivreEmpruntType, Date>();
	private CoordonneeUtilisateurType coordonneeUtilisateur = new CoordonneeUtilisateurType();

	private Map<ReservationType, HashMap<Date, Integer>> listReservation = new HashMap<ReservationType, HashMap<Date, Integer>>();

	/**
	 * Méthode retournant les données nécessaires à la jsp affichant le compte d'un
	 * {@link UtilisateurType}
	 */
	@Override
	public String execute() {
		BiblioWS biblioWS = this.webAppConfig.accesWS();
		this.utilisateur = ((UtilisateurType) this.session.get("utilisateur"));
		logger.debug("Compte de " + this.utilisateur.getPseudo());
		try {

			List<ReservationType> vReservations = biblioWS.obtenirReservationUtilisateur(this.utilisateur.getId());
			Map<Date, Integer> maMapInt = new HashMap<Date, Integer>();
			Integer maPosition = 0;
			for (int i = 0; i < vReservations.size(); i++) {
				List<LivreEmpruntType> vListInt = biblioWS.obtenirEmpruntLivre(vReservations.get(i).getLivre().getId());
				Collections.sort(vListInt, (d1, d2) -> d1.getDateEmprunt().compare(d2.getDateEmprunt()));
				Calendar calTemoin = Calendar.getInstance();
				calTemoin.setTime(vListInt.get(0).getDateEmprunt().toGregorianCalendar().getTime());
				System.out.println("CTRL date ---------------" + calTemoin.getTime().toString());
				calTemoin.add(Calendar.DAY_OF_MONTH, 28);
				System.out.println("CTRL date ---------------" + calTemoin.getTime().toString());
				for (LivreEmpruntType let : vListInt) {// --est-ce qu'il parcours dans l'ordre ?
					Calendar cal1 = Calendar.getInstance();
					cal1.setTime(let.getDateEmprunt().toGregorianCalendar().getTime());
					if (let.isProlongation()) {
						cal1.add(Calendar.DAY_OF_MONTH, 28);
					} else {
						cal1.add(Calendar.DAY_OF_MONTH, 28 * 2);
					}

					if (cal1.before(calTemoin)) {
						calTemoin = cal1;
					}

					// if (let.getEmprunteur().getId() != this.utilisateur.getId()) {
					// maPosition++;
					// } else {
					// maPosition++;
					// break;
					// }
					// System.out.println("---------liste triee--------" + let.getDateEmprunt() + "
					// -- "+ let.getEmprunteur().getId());

				}

				// --Pour position de utilisateur, besoin d'une operation
				// obtenirReservationLivre(int idLivre)
				System.out.println("CTRL ---------- " + vReservations.get(i).getLivre().getId());
				List<ReservationType> mesUserResa = biblioWS
						.obtenirReservationOuvrage(vReservations.get(i).getLivre().getId());
				System.out.println("CTRL ------------" + mesUserResa.size());
				for (int j = 0; j < mesUserResa.size(); j++) {
					System.out.println(
							"ID-----" + mesUserResa.get(j).getUtilisateur().getId() + " - " + this.utilisateur.getId());
					if (mesUserResa.get(j).getUtilisateur().getId() == this.utilisateur.getId()) {

						maPosition = j + 1;
						break;
					}
				}
				System.out.println("CTRL---------" + maMapInt.size());
				maMapInt.put(calTemoin.getTime(), maPosition);

				this.listReservation.put(vReservations.get(i), (HashMap<Date, Integer>) maMapInt);

			}

			List<LivreEmpruntType> vEmprunts = biblioWS.obtenirEmpruntUtilisateur(this.utilisateur.getId());
			this.coordonneeUtilisateur.setAdresse(this.utilisateur.getCoordonnee().get(0).getAdresse());
			this.coordonneeUtilisateur.setEmail(this.utilisateur.getCoordonnee().get(0).getEmail());

			for (int i = 0; i < vEmprunts.size(); i++) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(vEmprunts.get(i).getDateEmprunt().toGregorianCalendar().getTime());
				cal.add(Calendar.DAY_OF_MONTH, 28);
				this.listEmprunt.put(vEmprunts.get(i), cal.getTime());
			}
			return ActionSupport.SUCCESS;
		} catch (ObtenirEmpruntUtilisateurFault_Exception e) {
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			logger.debug(e.getMessage());
			return ActionSupport.INPUT;
		} catch (SOAPFaultException e1) {
			logger.debug(e1.getMessage());
			this.addActionMessage(e1.getMessage());
			e1.printStackTrace();
			return ActionSupport.INPUT;
		} catch (ObtenirReservationUtilisateurFault_Exception e2) {
			this.addActionMessage(e2.getMessage());
			e2.printStackTrace();
			logger.debug(e2.getMessage());
			return ActionSupport.INPUT;
		} catch (ObtenirEmpruntLivreFault e3) {
			this.addActionMessage(e3.getMessage());
			e3.printStackTrace();
			logger.debug(e3.getMessage());
			return ActionSupport.INPUT;
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UtilisateurType getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(UtilisateurType utilisateur) {
		this.utilisateur = utilisateur;
	}

	public CoordonneeUtilisateurType getCoordonneeUtilisateur() {
		return this.coordonneeUtilisateur;
	}

	public void setCoordonneeUtilisateur(CoordonneeUtilisateurType coordonneeUtilisateur) {
		this.coordonneeUtilisateur = coordonneeUtilisateur;
	}

	public Map<LivreEmpruntType, Date> getListEmprunt() {
		return this.listEmprunt;
	}

	public void setListEmprunt(Map<LivreEmpruntType, Date> listEmprunt) {
		this.listEmprunt = listEmprunt;
	}

	public BiblioWebAppConfiguration getWebAppConfig() {
		return this.webAppConfig;
	}

	@Autowired
	public void setWebAppConfig(BiblioWebAppConfiguration webAppConfig) {
		this.webAppConfig = webAppConfig;
	}

	public Map<ReservationType, HashMap<Date, Integer>> getListReservation() {
		return this.listReservation;
	}

	public void setListReservation(Map<ReservationType, HashMap<Date, Integer>> listReservation) {
		this.listReservation = listReservation;
	}

}
