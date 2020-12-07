package com.usermanager.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
import org.apache.log4j.Logger;

/**
 * Replacing with JPA and HIBERNATE persistence layer 
 */
public class DbConnection {
	private Connection conn;
	private String dbURL;
	private String dbUser;
	private String dbPWD; 
	private static final Logger logger = Logger.getLogger(DbConnection.class);
	
	public DbConnection(String User, String PWD, String URL) {
	
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void closeConnection() {
		logger.info(" Connection Closed ");
	}
}
