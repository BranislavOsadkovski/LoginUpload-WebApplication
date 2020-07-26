package com.servletstudy.dbUtil;

import javax.servlet.ServletContext;

public class UserDAOManager {
	private  UserDAO userDAO= null;
	
	public UserDAO getUserDAOInstance(ServletContext context) {
		if(this.userDAO==null) {
			this.userDAO = new UserDAO(context);
		}
			return userDAO;
			
			
	}
}
