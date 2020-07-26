package com.servletstudy.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.servletstudy.db_util.DbConnection;
@WebListener
public class AppContextListener implements ServletContextListener{
	/**Read ServletContext initial parameters to create the DBConnectionManager object and 
	 * set attribute to the ServletContext object.
	 */
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
    	System.out.println("DbConnection Attribute set to ServletContext");
	}
	
	/**Closing Connection When ServletContext Destroyed method is called**/
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		//Getting DbConnection Object from ServletContext Attribute 
		DbConnection dbConn = (DbConnection) servletContext.getAttribute("DbConnection");
		dbConn.closeConnection(); 	 	
	}

}
