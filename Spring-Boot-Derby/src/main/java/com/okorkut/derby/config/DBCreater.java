package com.okorkut.derby.config;

import org.springframework.beans.factory.annotation.Autowired;

public class DBCreater {

	@Autowired
	private static DBConnectionConfig dbConnectionConfig;
	
	public void print() {
		System.out.println(dbConnectionConfig.getDbConnectionParameters().getDbDriver());
	}
}
