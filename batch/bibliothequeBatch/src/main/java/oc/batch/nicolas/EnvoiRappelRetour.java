package oc.batch.nicolas;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.UtilisateurType;
import oc.batch.nicolas.mapper.MapperLivreEmprunt;
import oc.batch.nicolas.mapper.MapperUtilisateur;
import oc.batch.nicolas.model.LivreEmprunt;
import oc.batch.nicolas.model.Utilisateur;

public class EnvoiRappelRetour implements Tasklet {

	private BiblioWS biblioWS;
	private MailHandler mh;

	public EnvoiRappelRetour(String wsUrl) {
		final JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setAddress(wsUrl);
		this.setBiblioWS(proxyFactory.create(BiblioWS.class));
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyTaskThree start.. recuperation des rappels");
		new ArrayList<Utilisateur>();
		for (UtilisateurType u : this.biblioWS.listeRappelRetour("").getUtilisateur()) {
			Utilisateur monUser = MapperUtilisateur.fromUtilisateurTypeToUtilisateur(u);
			List<LivreEmprunt> mesEmpruntsRappels = new ArrayList<LivreEmprunt>();
			for (LivreEmpruntType let : this.biblioWS.listeRappelRetour("").getLivreEmprunt()) {
				mesEmpruntsRappels.add(MapperLivreEmprunt.fromLivreEmpruntTypeToLivreEmprunt(let));
			}
			this.mh = new MailHandler(monUser, mesEmpruntsRappels);
			this.mh.sendMailRappel();
		}

		return null;
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
