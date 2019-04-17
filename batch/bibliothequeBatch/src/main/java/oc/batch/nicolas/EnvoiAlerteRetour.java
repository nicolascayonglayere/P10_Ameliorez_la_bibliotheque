package oc.batch.nicolas;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.ListeAlerteRetourResponse;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.UtilisateurType;
import oc.batch.nicolas.mapper.MapperLivre;
import oc.batch.nicolas.mapper.MapperUtilisateur;
import oc.batch.nicolas.model.Livre;
import oc.batch.nicolas.model.Utilisateur;

public class EnvoiAlerteRetour implements Tasklet {

	private BiblioWS biblioWS;
	private MailHandler mh;

	public EnvoiAlerteRetour(String wsUrl) {
		final JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setAddress(wsUrl);
		this.biblioWS = proxyFactory.create(BiblioWS.class);
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(
				"MyTaskTwo start.. recuperation des livres retournés dans la journée présents sur liste d'attente");
		ListeAlerteRetourResponse larr = this.biblioWS.listeAlerteRetour("");
		List<UtilisateurType> utilisateursAlerte = larr.getUtilisateur();
		System.out.println("nb d'alerte " + utilisateursAlerte.size());
		List<LivreType> livreAlerte = larr.getLivre();

		for (int i = 0; i < utilisateursAlerte.size(); i++) {
			Utilisateur monUser = MapperUtilisateur.fromUtilisateurTypeToUtilisateur(utilisateursAlerte.get(i));
			Livre monLivre = MapperLivre.fromLivreTypeToLivre(livreAlerte.get(i));
			this.mh = new MailHandler(monUser, monLivre);
			this.mh.sendMailAlerte();
		}

		return RepeatStatus.FINISHED;
	}

	public BiblioWS getBiblioWS() {
		return this.biblioWS;
	}

	public void setBiblioWS(BiblioWS biblioWS) {
		this.biblioWS = biblioWS;
	}

	public MailHandler getMh() {
		return this.mh;
	}

	public void setMh(MailHandler mh) {
		this.mh = mh;
	}

}
