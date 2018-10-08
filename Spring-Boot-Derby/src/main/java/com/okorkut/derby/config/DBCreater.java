package com.okorkut.derby.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.okorkut.derby.db.utils.DbUtil;


@Configuration
public class DBCreater {
	
	private static final Logger logger = LogManager.getLogger(DBCreater.class);
	
	public static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static String JDBC_URL = "jdbc:derby:okorkut:create=true";
	
	@Autowired
	private DBConnectionConfig dbConnectionConfig;
	
	
	@PostConstruct
	public void initialize() {
		 print();
	}
	
	public void print() {
		System.out.println(dbConnectionConfig.getDbConnectionParameters().getDbDriver());
		
		try {

			createdb();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void createdb() throws Exception{
		Connection con = null;
		PreparedStatement pStmt = null;
		PreparedStatement psInsert = null;
		PreparedStatement psSelect = null;
		ResultSet rs = null;
		ResultSet rsSelect = null;

		String sql = "CREATE TABLE TestLogger (" +
				  "id        	INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
				  "loggerKey 	VARCHAR(30)," +
				  "loggerValue   VARCHAR(50)," +
				  "CONSTRAINT primary_key PRIMARY KEY (id)" +
				")";
		
		try {
			con = DbUtil.getConnection(dbConnectionConfig.getDbConnectionParameters());
			
			
			try {
				pStmt = con.prepareStatement(sql);
				
				pStmt.executeUpdate();
			} catch (SQLException se) {
				if(se.getSQLState().equals("X0Y32")) {
					logger.info("Talbe already exists.  No need to recreate");
				} else {
					logger.error(se.getMessage() + " : " + se.getStackTrace());
					throw se;
				}
			}
			
			psInsert = con.prepareStatement("insert into TestLogger(loggerKey,loggerValue) values (?,?)");
			psInsert.setString(1, "test1key");
			psInsert.setString(2, "test1value");
			
			psInsert.executeUpdate();
			
			psSelect = con.prepareStatement("select * from TestLogger");
			rsSelect = psSelect.executeQuery();
		    int num = 0;
	
		    while (rsSelect.next()) {
		     logger.info(rsSelect.getString(1) + " " + rsSelect.getString(2)+ " " + rsSelect.getString(3));
		    }
		}  catch (Exception e) {
			logger.error(e);
			throw e;
		} finally {
			DbUtil.close(con, pStmt, rs);
			DbUtil.close(null, psInsert, null);
			DbUtil.close(null, psSelect,  rsSelect);
		}
	}
}
