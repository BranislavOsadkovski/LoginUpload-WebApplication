package com.usermanager.listeners;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
@WebListener
public class ServletRequestListenerClass implements ServletRequestListener {
	final private static Logger logger = Logger.getLogger(ServletRequestListenerClass.class);
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		ServletRequest servletRequest = sre.getServletRequest();
		//Notification marker
		logger.info("ServletRequest Destroyed RemoteIP= " + servletRequest.getRemoteAddr());
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		ServletRequest servletRequest = sre.getServletRequest();
		//Notification marker
		logger.info("ServletRequest Initialized RemoteIP= " + servletRequest.getRemoteAddr());
	}

}
