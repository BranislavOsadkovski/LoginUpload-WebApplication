package com.usermanager.dbUtil;

/**
 * Replacing with JPA and Hibernate persistence layer 
 */
public class UserDAOManager {
	private  UserDAO userDAO= null;
	
	public UserDAO getUserDAOInstance() {
			if(this.userDAO==null) {
				this.userDAO = new UserDAO();
			}
		return userDAO;
	}
}
