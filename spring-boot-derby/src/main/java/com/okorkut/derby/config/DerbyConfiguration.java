package com.okorkut.derby.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DBConnectionConfig.class)
public class DerbyConfiguration {

	@Bean
	public DBConnectionConfig dbConnectionConfig() {
		return new DBConnectionConfig();
	}

	
	
}
