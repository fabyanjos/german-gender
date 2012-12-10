package com.fabiale.german.spring.context;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import com.fabiale.german.spring.RepositoryConfig;
import com.fabiale.german.spring.WebConfig;

@Configuration
@ComponentScan(value = "com.fabiale.german", excludeFilters = @ComponentScan.Filter(Configuration.class))
@Import({ RepositoryConfig.class, WebConfig.class })
public class SpringConfig {

	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("application.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}
}
