package tw.com.reinbach.wonderful.tools.springMVC;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.XmlViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("tw.com.reinbach.wonderful.controller")
public class SpringMVCJavaConfig extends WebMvcConfigurerAdapter implements WebApplicationInitializer {

	private String TMP_FOLDER = "/tmp";
	private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

	@Autowired
	private ServletContext application;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		ServletRegistration.Dynamic appServlet = servletContext.addServlet("mvc",
				new DispatcherServlet(new GenericWebApplicationContext()));
		appServlet.setLoadOnStartup(1);
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER, MAX_UPLOAD_SIZE,
				MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
		appServlet.setMultipartConfig(multipartConfigElement);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		Resource resource = new ServletContextResource(application, "/WEB-INF/views.xml");
		XmlViewResolver xmlViewResolver = new XmlViewResolver();
		xmlViewResolver.setLocation(resource);
		registry.viewResolver(xmlViewResolver);
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResovler() {
		final CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8");
		multipartResolver.setMaxUploadSize(10000000);
		return multipartResolver;
	}

}
