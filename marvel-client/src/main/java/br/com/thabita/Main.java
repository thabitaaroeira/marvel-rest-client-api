package br.com.thabita;

import java.util.HashSet;
import java.util.Set;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sun.faces.config.FacesInitializer;

@Configuration
@ComponentScan(basePackages = { "" })
@EnableAutoConfiguration
@SpringBootApplication
public class Main extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { Main.class, Initializer.class });
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
		return servletRegistrationBean;
	}

	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean servletRegistrationBean = new JsfServletRegistrationBean();
		return servletRegistrationBean;
	}

	public class JsfServletRegistrationBean extends ServletRegistrationBean {
		public JsfServletRegistrationBean() {
			super();
		}

		@Override
		public void onStartup(ServletContext servletContext) throws ServletException {
			FacesInitializer facesInitializer = new FacesInitializer();

			Set<Class<?>> clazz = new HashSet<Class<?>>();
			clazz.add(Main.class);
			facesInitializer.onStartup(clazz, servletContext);
		}
	}

}
