package com.daw.cinuja.spring;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring +3.0 programmatic configuration
 *
 * @author jrbalsas
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.daw.cinuja"})
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * This is intended to be used when the Spring MVC DispatcherServlet is
     * mapped to "/" thus overriding the Servlet container's default handling of
     * static resources.
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //Locate JSP views 
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * Map routes to views without a controller
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/portada");
    }

    @Bean
    public DataSource getDataSource() {

        DataSource ds = null;

        try {
            //Get DataSource using JNDI
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:global/jdbc/Cinuja");
        } catch (NamingException e) {
            Logger.getGlobal().log(Level.SEVERE, e.getMessage());
        }
        return ds;
    }

}
