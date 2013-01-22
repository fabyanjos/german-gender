package com.fabiale.german.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fabiale.german.gson.GSONHttpMessageConverter;

@Configuration
@EnableWebMvc
@ComponentScan("com.fabiale.german")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("/js/**");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/**");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/**");
		super.addResourceHandlers(registry);
	}
	
	@Autowired private GSONHttpMessageConverter jsonConverter;
	
	@Bean public Jaxb2RootElementHttpMessageConverter xmlConverter() {
		return new Jaxb2RootElementHttpMessageConverter();
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(jsonConverter);
		converters.add(xmlConverter());
		super.configureMessageConverters(converters);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index.jsp").setViewName("index");
	}
}
