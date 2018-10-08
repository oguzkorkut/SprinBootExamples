package com.okorkut.derby.config;

public class DBConnectionParameters {
	private DBType dbType = DBType.MSSQL;
	private String dbJdbcURL = null;
	private String dbUserName = null;
	private String dbPassword = null;
	private String dbDriver = null;
	private String initSQL = null;
	//
	private String dbDataSourceName = null;
	private boolean dbJdbcPooled = false;
	private boolean isolationOn;

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

	public String getInitSQL() {
		return initSQL;
	}

	public void setInitSQL(String initSQL) {
		this.initSQL = initSQL;
	}

	public void setIsolationOn(boolean isolationOn) {
		this.isolationOn = isolationOn;
	}

	public boolean isIsolationOn() {
		return isolationOn;
	}

	public DBType getDbType() {
		return dbType;
	}

	public void setDbType(DBType dbType) {
		this.dbType = dbType;
	}

}
