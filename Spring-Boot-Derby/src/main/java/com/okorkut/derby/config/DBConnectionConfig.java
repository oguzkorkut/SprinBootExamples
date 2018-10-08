package com.okorkut.derby.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.okorkut.derby.dao.utils.DBType;

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

	public static class DBConnectionParameters {
		private int dbType = DBType.MSSQL.getDbType();
		private String dbJdbcURL = null;
		private String dbUserName = null;
		private String dbPassword = null;
		private String dbDriver = null;
		private String initSQL = null;
		//
		private String dbDataSourceName = null;
		private boolean dbJdbcPooled = false;
		private boolean isolationOn;

		public int getDbType() {
			return dbType;
		}

		public void setDbType(int dbType) {
			this.dbType = dbType;
		}

		public String getDbJdbcURL() {
			return dbJdbcURL;
		}

		public void setDbJdbcURL(String dbJdbcURL) {
			this.dbJdbcURL = dbJdbcURL;
		}

		public String getDbUserName() {
			return dbUserName;
		}

		public void setDbUserName(String dbUserName) {
			this.dbUserName = dbUserName;
		}

		public String getDbPassword() {
			return dbPassword;
		}

		public void setDbPassword(String dbPassword) {
			this.dbPassword = dbPassword;
		}

		public String getDbDriver() {
			return dbDriver;
		}

		public void setDbDriver(String dbDriver) {
			this.dbDriver = dbDriver;
		}

		public String getInitSQL() {
			return initSQL;
		}

		public void setInitSQL(String initSQL) {
			this.initSQL = initSQL;
		}

		public String getDbDataSourceName() {
			return dbDataSourceName;
		}

		public void setDbDataSourceName(String dbDataSourceName) {
			this.dbDataSourceName = dbDataSourceName;
		}

		public boolean isDbJdbcPooled() {
			return dbJdbcPooled;
		}

		public void setDbJdbcPooled(boolean dbJdbcPooled) {
			this.dbJdbcPooled = dbJdbcPooled;
		}

		public boolean isIsolationOn() {
			return isolationOn;
		}

		public void setIsolationOn(boolean isolationOn) {
			this.isolationOn = isolationOn;
		}

	}
}
