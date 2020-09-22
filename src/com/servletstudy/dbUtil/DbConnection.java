package com.servletstudy.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
import org.apache.log4j.Logger;

public class DbConnection {
	private Connection conn;
	private String dbURL;
	private String dbUser;
	private String dbPWD; 
	private static final Logger logger = Logger.getLogger(DbConnection.class);
	
	public DbConnection(String User, String PWD, String URL) {
		this.dbUser = User;
		this.dbPWD = PWD;
		this.dbURL = URL;
		/** 	This code is only simulating connection to the database and this code will cause an exception to be thrown
			that will be handled by the try-catch block
		*/
		try {
			this.conn = DriverManager.getConnection(this.dbURL, this.dbUser, this.dbPWD);
			} 
		catch (SQLException e) { 
				/**Handle Exception */
				logger.error(e.getMessage());
			}
		//Notification marker
		logger.info(" DBConnection achieved ("+this.dbURL+", "+ this.dbUser +", "+ this.dbPWD+ ") ");
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void closeConnection() {
		//Notification marker
		//Closing Database Connection here
		logger.info(" Connection Closed ");
	}
}
