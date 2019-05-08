package oc.webApp.nicolas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Classe contenant le point d'entrée du programme
 *
 */

@SpringBootApplication
public class App extends SpringBootServletInitializer {
	/**
	 * Méthode main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}
}
