package com.boavista.jobbatch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PropsConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(PropsConfig.class);
	
	@Bean
	public PropertySourcesPlaceholderConfigurer config() {
		PropertySourcesPlaceholderConfigurer configurer =  new PropertySourcesPlaceholderConfigurer();
		configurer.setLocation(new FileSystemResource("C:/Projetos/Batch/config/application.properties"));
		return configurer;
	}
	

}
