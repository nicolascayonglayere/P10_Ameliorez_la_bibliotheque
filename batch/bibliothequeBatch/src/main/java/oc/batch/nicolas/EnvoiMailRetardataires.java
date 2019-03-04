package oc.batch.nicolas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.ListRetardatairesResponse;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.UtilisateurType;
import oc.batch.nicolas.mapper.MapperLivreEmprunt;
import oc.batch.nicolas.mapper.MapperUtilisateur;
import oc.batch.nicolas.model.LivreEmprunt;
import oc.batch.nicolas.model.Utilisateur;

/**
 * Classe qui envoie les mails aux retardataires
 * 
 * @author nicolas
 *
 */
public class EnvoiMailRetardataires implements Tasklet {

	private List<UtilisateurType> retardataires = new ArrayList<UtilisateurType>();
	private BiblioWS biblioWS;
	private MailHandler mh;

	/**
	 * Constructeur avec paramètre
	 * 
	 * @param wsUrl
	 */
	public EnvoiMailRetardataires(String wsUrl) {
		final JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setAddress(wsUrl);
		this.biblioWS = proxyFactory.create(BiblioWS.class);
	}

	/**
	 * Méthode qui récupère les retardataires et leur envoie des mails de relance
	 */
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyTaskOne start.. recuperation des retardataires");
		// --calcul date retard
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -28);
		ListRetardatairesResponse lrr = this.biblioWS.listRetardataires("");
		this.retardataires = lrr.getUtilisateur();
		System.out.println("nb retardataire : " + this.retardataires.size());
		for (UtilisateurType u : this.retardataires) {
			System.out.println("nb retard : " + u.getEmprunt().size());
			for (LivreEmpruntType et : u.getEmprunt()) {
				if ((et.getDateEmprunt().toGregorianCalendar().getTime()).before(cal.getTime())) {
					// --envoi de mail
					Utilisateur monUser = MapperUtilisateur.fromUtilisateurTypeToUtilisateur(u);
					LivreEmprunt monEmprunt = MapperLivreEmprunt.fromLivreEmpruntTypeToLivreEmprunt(et);
					this.mh = new MailHandler(monUser, monEmprunt);
					this.mh.sendMail();
				}
			}
		}

		return RepeatStatus.FINISHED;
	}

	// --Getter et Setter
	public List<UtilisateurType> getRetardataires() {
		return this.retardataires;
	}

	public void setRetardataires(List<UtilisateurType> retardataires) {
		this.retardataires = retardataires;
	}

	public MailHandler getMh() {
		return this.mh;
	}

	public void setMh(MailHandler mh) {
		this.mh = mh;
	}

}
