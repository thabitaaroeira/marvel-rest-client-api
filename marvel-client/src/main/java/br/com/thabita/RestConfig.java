package br.com.thabita;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.com.thabita.resource.CharacterController;
import br.com.thabita.resource.CreatorController;

@Configuration
@ApplicationPath("/api")
public class RestConfig extends ResourceConfig {

	public RestConfig() {
		super.register(CharacterController.class);
		super.register(CreatorController.class);
	}

}
