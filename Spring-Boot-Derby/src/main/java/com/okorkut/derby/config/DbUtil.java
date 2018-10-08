package com.okorkut.derby.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DbUtil {
	private static final Logger logger = LogManager.getLogger(DbUtil.class);


	public static void close(Connection con, Statement stmt, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(stmt);
		closeConnection(con);
	}

	public static Connection getConnection(DBConnectionParameters dbConnParams) throws Exception {
		if (dbConnParams.isDbJdbcPooled()) {
			return getConnectionFromDatasource(dbConnParams);
		} else {
			return getConnectionLocal(dbConnParams);
		}
	}

	public static Connection getConnectionLocal(DBConnectionParameters dbConnParams) throws Exception {
		Connection newConn = null;
		Class.forName(dbConnParams.getDbDriver()).newInstance();
		newConn = DriverManager.getConnection(dbConnParams.getDbJdbcURL(), dbConnParams.getDbUserName(), dbConnParams.getDbPassword());
		logger.debug("Connection taken :" + newConn.getAutoCommit());

		if (dbConnParams.isIsolationOn()) {
			newConn.setTransactionIsolation(4096);
		}

		if (!StringUtils.isBlank(dbConnParams.getInitSQL())) {
			newConn.createStatement().execute(dbConnParams.getInitSQL());
		}

		return newConn;
	}

	public static Connection getTransactionalConnection(DBConnectionParameters dbConnParams) throws Exception {
		Connection conn = getConnection(dbConnParams);
		startTransaction(conn);
		return conn;
	}

	private static Connection getConnectionFromDatasource(DBConnectionParameters dbConnParams) throws NamingException, SQLException {
		logger.debug("DataSource " + dbConnParams.getDbDataSourceName());
		Context envCtx = new InitialContext();
		// Look up our data source
		DataSource ds = (DataSource) envCtx.lookup(dbConnParams.getDbDataSourceName());
		Connection conn = ds.getConnection();
		logger.debug("Connection taken");
		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			// Check auto commit and transaction
			if (conn != null && !conn.isClosed()) {

//				if (!conn.getAutoCommit()) {
//					conn.rollback();
//					conn.setAutoCommit(true);
//				}
				conn.close();
				logger.debug("Connection is closed");
			}
		} catch (Exception e) {
			logger.error(e, e);
		}

	}

	public static void startTransaction(Connection conn) throws SQLException {
		if (conn != null && !conn.isClosed()) {

			if (conn.getAutoCommit()) {
				conn.setAutoCommit(false);
			} else {
				// Devam eden transaction varsa roolback yapalim
				logger.warn("Transaction is already active. Rollbacking active transaction");
				conn.rollback();
			}

		}

	}

	public static void commitTransaction(Connection conn) throws SQLException {
		if (conn != null && !conn.isClosed()) {

			if (!conn.getAutoCommit()) {
				conn.commit();
			} else {
				// Devam eden transaction varsa roolback yapalim
				logger.debug("Transaction is not active.");
			}
			conn.setAutoCommit(true);
		}

	}

	public static void rollbackTransaction(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {

				if (!conn.getAutoCommit()) {
					conn.rollback();
				} else {
					// Devam eden transaction varsa roolback yapalim
					logger.debug("Transaction is not active.");
				}
				conn.setAutoCommit(true);
			}
		} catch (Exception e) {
			logger.error(e, e);
		}
	}

	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				logger.debug("Statement is closed");
			}
		} catch (Exception e) {
			logger.error(e, e);
		}

	}

	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				logger.debug("ResultSet is closed");
			}
		} catch (Exception e) {
			logger.error(e, e);
		}

	}

}
