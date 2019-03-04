package OC.webService.nicolas.appSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Classe App contenant le point d'entrée
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "OC.webService.nicolas")
@ComponentScan(basePackages = "OC.webService.nicolas")
@EntityScan(basePackages = "OC.webService.nicolas")
public class App extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(App.class);
	}

}
