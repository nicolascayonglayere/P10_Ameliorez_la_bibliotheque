package oc.webApp.nicolas.actions;

import java.util.Map;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.AnnulerReservationFault_Exception;
import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.ReserverOuvrageFault_Exception;
import fr.yogj.bibliows.types.UtilisateurType;
import oc.webApp.nicolas.configurations.BiblioWebAppConfiguration;

@Service
public class GestionReservation extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private BiblioWebAppConfiguration webAppConfig;
	private Map<String, Object> session;
	private UtilisateurType utilisateur;
	private String idResa;
	private String id;
	private String idLivre;

	public String annuler() {
		BiblioWS biblioWS = this.webAppConfig.accesWS();
		this.utilisateur = ((UtilisateurType) this.session.get("utilisateur"));
		logger.debug("Compte de " + this.utilisateur.getPseudo());
		System.out.println("CTRL-----------" + this.idResa);
		try {
			biblioWS.annulerReservation(Integer.valueOf(this.idResa));
			return ActionSupport.SUCCESS;
		} catch (AnnulerReservationFault_Exception e) {
			logger.debug(e.getMessage());
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			return ActionSupport.INPUT;
		}

	}

	public String reserver() {
		BiblioWS biblioWS = this.webAppConfig.accesWS();
		this.utilisateur = ((UtilisateurType) this.session.get("utilisateur"));
		logger.debug("Compte de " + this.utilisateur.getPseudo());
		System.out.println("CTRL-----------" + this.utilisateur.getPseudo() + " " + this.idLivre);
		try {
			biblioWS.reserverOuvrage(Integer.valueOf(this.idLivre), this.utilisateur.getId());
			return ActionSupport.SUCCESS;
		} catch (ReserverOuvrageFault_Exception e) {
			logger.debug(e.getMessage());
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			return ActionSupport.INPUT;
		} catch (SOAPFaultException e1) {
			logger.debug(e1.getMessage());
			this.addActionMessage(e1.getMessage());
			e1.printStackTrace();
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

	public BiblioWebAppConfiguration getWebAppConfig() {
		return this.webAppConfig;
	}

	@Autowired
	public void setWebAppConfig(BiblioWebAppConfiguration webAppConfig) {
		this.webAppConfig = webAppConfig;
	}

	// public String getIdReservation() {
	// return this.idReservation;
	// }
	//
	// public void setIdReservation(String idReservation) {
	// this.idReservation = idReservation;
	// }

	public String getIdLivre() {
		return this.idLivre;
	}

	public void setIdLivre(String idLivre) {
		this.idLivre = idLivre;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdResa() {
		return this.idResa;
	}

	public void setIdResa(String idResa) {
		this.idResa = idResa;
	}

}
