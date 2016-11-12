package br.com.thabita;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import br.com.thabita.resource.CharacterResource;
import br.com.thabita.resource.ComicResource;
import br.com.thabita.resource.CreatorResource;

@ApplicationPath("/marvel-client-api")
@ComponentScan(basePackages = "br.com.thabita.business")
@PropertySource(value = { "classpath:application.properties" })
@Configuration
public class RestConfig extends ResourceConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public RestConfig() {
		super.register(CharacterResource.class);
		super.register(ComicResource.class);
		super.register(CreatorResource.class);
	}

}
