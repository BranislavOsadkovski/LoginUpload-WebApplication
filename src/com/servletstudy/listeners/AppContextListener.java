package com.servletstudy.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.servletstudy.dbUtil.DbConnection;
@WebListener
public class AppContextListener implements ServletContextListener{
	/**Read ServletContext initial parameters and create the DBConnectionManager object and 
	 * set it as attribute to the ServletContext
	 */
	private final static Logger logger = Logger.getLogger(AppContextListener.class);
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		String url = servletContext.getInitParameter("DBURL");
    	String user = servletContext.getInitParameter("DBUSER");
    	String pwd = servletContext.getInitParameter("DBPWD");
    	//Create Database Connection Object from initial parameters and set it to ServletContext
    	DbConnection dbConn = new DbConnection(user, pwd, url);
    	servletContext.setAttribute("DbConnection", dbConn);
    	//Notification marker
    	logger.info("DbConnection Attribute set to ServletContext");
	}
	
	/**
	 * Close Connection When ServletContext is destroyed 
	*/
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		//Get DbConnection Object from ServletContext Attribute 
		logger.info("AppContext destroyed");
		DbConnection dbConn = (DbConnection) servletContext.getAttribute("DbConnection");
		dbConn.closeConnection(); 	 	
	}

}
