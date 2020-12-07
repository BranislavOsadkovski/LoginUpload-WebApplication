package com.usermanager.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
@WebListener
public class SessionListener implements HttpSessionListener{

	final private static Logger logger = Logger.getLogger(SessionListener.class);
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//Notification marker
		logger.info("Session Created:: ID="+se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//Notification marker
		logger.info("Session Destroyed:: ID="+se.getSession().getId());
	}
 
}
