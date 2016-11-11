package br.com.thabita;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class Initializer implements WebApplicationInitializer, ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet());
		registration.setLoadOnStartup(1);
		registration.addMapping("/marvel-client-api-web/*");

		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
	}

}
