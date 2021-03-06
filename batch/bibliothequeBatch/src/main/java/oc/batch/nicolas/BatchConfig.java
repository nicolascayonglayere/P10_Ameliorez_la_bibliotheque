package oc.batch.nicolas;

import java.util.concurrent.Executor;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

/**
 * Classe de configuration du batch
 * 
 * @author nicolas
 *
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {

	private String wsUrl;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	/**
	 * Méthode pour construire la tache du job 1 (Envoi de mail aux retardataires)
	 * 
	 * @return {@link Step}
	 */
	@Bean
	public Step step1() {
		return this.stepBuilderFactory.get("step1").tasklet(new EnvoiMailRetardataires(this.wsUrl)).build();
	}

	/**
	 * Méthode pour construire la tache du job 2 (Envoi de mail d'alerte de retour
	 * d'un ouvrage réservé)
	 * 
	 * @return {@link Step}
	 */
	@Bean
	public Step step2() {
		return this.stepBuilderFactory.get("step2").tasklet(new EnvoiAlerteRetour(this.wsUrl)).build();
	}

	/**
	 * Méthode pour construire la tache du job 3 (Envoi de mail de rappel pour le
	 * retour imminent d'un ouvrage
	 * 
	 * @return {@link Step}
	 */
	@Bean
	public Step step3() {
		return this.stepBuilderFactory.get("step3").tasklet(new EnvoiRappelRetour(this.wsUrl)).build();
	}

	/**
	 * Méthode pour construire le job
	 * 
	 * @return {@link Job}
	 */
	@Bean
	public Job job() {
		return this.jobBuilderFactory.get("job").start(this.step1()).next(this.step2()).next(this.step3()).build();
	}

	/**
	 * Méthode pour construire le TaskScheduler
	 * 
	 * @return {@link ConcurrentTaskScheduler}
	 */
	@Bean
	public TaskScheduler taskScheduler() {
		return new ConcurrentTaskScheduler();
	}

	/**
	 * Méthode pour construire l'executeur de job
	 * 
	 * @return ]{@link SimpleAsyncTaskExecutor}
	 */
	@Bean
	public Executor taskExecutor() {
		return new SimpleAsyncTaskExecutor();
	}

	/**
	 * Méthode pour définir l'absence de datasource
	 */
	@Override
	public void setDataSource(DataSource dataSource) {
		// This BatchConfigurer ignores any DataSource
	}

	// --Getter et setter
	public String getWsUrl() {
		return this.wsUrl;
	}

	@Value("${ws.url}")
	public void setWsUrl(String wsUrl) {
		this.wsUrl = wsUrl;
	}

}
