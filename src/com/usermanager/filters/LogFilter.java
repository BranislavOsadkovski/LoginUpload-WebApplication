package com.usermanager.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class LogFilter implements Filter{
	private static final Logger logger = Logger.getLogger(LogFilter.class); 
	@Override
	public void init(FilterConfig filterConfig) {
		filterConfig.getServletContext().log("LogFilter initialized");
		
		//Get the initial parameter from web.xml file
		String password = filterConfig.getInitParameter("password-param");
		filterConfig.getServletContext().setAttribute("password", password);
		//Notification marker 
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//IP Address of client machine
		String ipAddress = request.getRemoteAddr();
		
		//Log the IP address and time
		logger.info("Client ip : " + ipAddress + " / Time : " + new Date().toString());
		
		//pass the request down the filter chain
		chain.doFilter(request, response);
		
	}
	
	/* Called before the Filter instance is removed from service by the web container*/
	@Override
	public void destroy() {
		logger.info("Log Filter destroyed");
		//Close resources
	}

}
