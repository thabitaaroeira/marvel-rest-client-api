package br.com.thabita;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter 
		 {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet());
//		registration.setLoadOnStartup(1);
//		registration.addMapping("/");
//		registration.setInitParameter("contextAttribute", WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//
//		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
//		servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
//		servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
//		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
//		servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
//		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
//	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".xhtml");
		resolver.setViewClass(JstlView.class);
		registry.viewResolver(resolver);
	}

}
