package com.okorkut.derby.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.okorkut.derby.db.utils.DBConnectionParameters;

@Configuration
@PropertySource(value = "classpath:db-connection.properties")
@ConfigurationProperties("app")
public class DBConnectionConfig {

	private DBConnectionParameters dbConnectionParameters;

	public DBConnectionParameters getDbConnectionParameters() {
		return dbConnectionParameters;
	}

	public void setDbConnectionParameters(DBConnectionParameters dbConnectionParameters) {
		this.dbConnectionParameters = dbConnectionParameters;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
