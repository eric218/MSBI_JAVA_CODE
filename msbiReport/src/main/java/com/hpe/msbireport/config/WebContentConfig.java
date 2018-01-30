package com.hpe.msbireport.config;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import com.hpe.msbireport.viewResolver.ExcelViewResolver;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 27/12/17
 * Description:
 *  Configuration file.
 */
@Configuration
public class WebContentConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON).favorPathExtension(true);
    }

    /*
     * Configure ContentNegotiatingViewResolver
     */
    @Bean
    @Deprecated
    @Ignore
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        // Define view resolvers, from this place we add our extend view resolver, in this case we are going to add Excel.
        List<ViewResolver> resolvers = new ArrayList<>();
        resolvers.add(excelViewResolver());
        resolver.setViewResolvers(resolvers);
        return resolver;
    }

    /*
     * Configure View resolver to provide XLS output using Apache POI library to
     * generate XLS output for an object content
     */
    @Bean
    @Deprecated
    @Ignore
    public ViewResolver excelViewResolver() {
        return new ExcelViewResolver();
    }


    /*
     * Enable Thymeleaf to load static resources.
     *
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        super.addResourceHandlers(registry);
    }


}
