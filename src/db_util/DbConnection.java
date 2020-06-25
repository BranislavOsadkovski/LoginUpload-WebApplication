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
		try {this.conn = DriverManager.getConnection(this.dbURL, this.dbUser, this.dbPWD);} 
		catch (SQLException e) {System.out.println("::::::::::::::::::::::::::DBConnection achieved ("+this.dbURL+", "+ this.dbUser +", "+ this.dbPWD+ ")::::::::::::::::::::::::::");}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void closeConnection() {
		//Closing Database Connection here
		System.out.println("::::::::::::::::::::::::Connection Closed::::::::::::::::::::::::");
	}
}
