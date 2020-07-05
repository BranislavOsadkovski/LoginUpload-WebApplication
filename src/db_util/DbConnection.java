package db_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private Connection conn;
	private String dbURL;
	private String dbUser;
	private String dbPWD;

	public DbConnection(String User, String PWD, String URL) {
		this.dbUser = User;
		this.dbPWD = PWD;
		this.dbURL = URL;
		/** This code is only simulating connection to the 
		database and this code will cause an exception to be thrown
		that will be caught by the try-catch block
		*/
		try {this.conn = DriverManager.getConnection(this.dbURL, this.dbUser, this.dbPWD);} catch (SQLException e) {/**Handle Exception if it occurs*/}
		//Notification marker
		System.out.println("::::::::::::::::::::::::::DBConnection achieved ("+this.dbURL+", "+ this.dbUser +", "+ this.dbPWD+ ")::::::::::::::::::::::::::");
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void closeConnection() {
		//Notification marker
		//Closing Database Connection here
		System.out.println("::::::::::::::::::::::::Connection Closed::::::::::::::::::::::::");
	}
}
