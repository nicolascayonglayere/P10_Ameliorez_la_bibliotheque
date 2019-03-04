package oc.webApp.nicolas.configurations;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.yogj.bibliows.BiblioWS;

/**
 * Classe de configuration de la webApp
 * 
 * @author nicolas
 *
 */
@Configuration
@ConfigurationProperties(prefix = "cxf")
public class BiblioWebAppConfiguration {

	static final Logger logger = LogManager.getLogger();
	private String url;

	/**
	 * Méthode pour construire le SpringBus
	 * 
	 * @return SpringBus
	 */
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	/**
	 * Méthode pour connecter le web-service
	 * 
	 * @param bus
	 * @return BiblioWS
	 */
	@Bean
	public BiblioWS bus(SpringBus bus) {
		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setServiceClass(BiblioWS.class);
		bean.setAddress(this.url);
		bean.setBus(bus);
		return bean.create(BiblioWS.class);
	}

	public BiblioWS accesWS() {
		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setAddress(this.url);
		return bean.create(BiblioWS.class);

	}

	/**
	 * Méthode pour configurer Struts2
	 * 
	 * @return FilterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean<Filter> someFilterRegistration() {
		FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
		registration.setFilter(new StrutsPrepareAndExecuteFilter());
		registration.addUrlPatterns("*.action");
		registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
		registration.setName("StrutsPrepareAndExecuteFilter");
		return registration;
	}

	// --Getter et Setter
	public String getUrl() {
		return this.url;
	}

	@Value("${biblio.ws.endpoint.url}")
	public void setUrl(String url) {
		this.url = url;
	}

}
