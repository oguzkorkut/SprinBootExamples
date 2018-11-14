package com.okorkut;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SpringbootSpringdatajpaBootstrap.class)
@EnableAutoConfiguration
@SpringBootApplication
public class SpringbootSpringdatajpaBootstrap  extends SpringBootServletInitializer{

	
	private static final Logger logger = LogManager.getLogger(SpringbootSpringdatajpaBootstrap.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		
		setRegisterErrorPageFilter(false);
		application.sources(SpringbootSpringdatajpaBootstrap.class);
		
		return application.sources(SpringbootSpringdatajpaBootstrap.class);
	}

	public static void main(String[] args) {
		logger.trace("SpringbootSpringdatajpaBootstrap main started."); 
		SpringApplication.run(SpringbootSpringdatajpaBootstrap.class, args);
		logger.trace("SpringbootSpringdatajpaBootstrap main completed.");
	}

	

}
