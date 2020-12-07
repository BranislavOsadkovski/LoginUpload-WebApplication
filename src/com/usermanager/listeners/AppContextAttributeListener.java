package com.usermanager.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
@WebListener
public class AppContextAttributeListener implements ServletContextAttributeListener{
	private final static Logger logger = Logger.getLogger(AppContextAttributeListener.class);
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		String name =(String)event.getName();
		String  strValue= event.getValue().toString();
		//Notification marker
		logger.info("ServletContext added attribute ={"+name+":"+ strValue+"}");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		//Notification marker
		logger.info("ServletContext removed attribute ={"+event.getName()+":"+event.getValue()+"}");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		//Notification marker
		logger.info("ServletContext replaced attribute ={"+event.getName()+":"+event.getValue()+"}");
	}

	
	
	
}
