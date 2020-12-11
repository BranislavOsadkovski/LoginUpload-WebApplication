package com.usermanager.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter{
	private static final Logger logger = Logger.getLogger(AuthenticationFilter.class); 
 
	
	@Override
	public void init(FilterConfig fConfig) { 
		logger.info("AuthenticationFilter initialized");
		 
	}
	 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		String uri = httpRequest.getRequestURI();
		logger.info("Requested Resource : " +uri);
		
		HttpSession session = httpRequest.getSession(false);
		
		if(session==null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))) {
			logger.info("Unauthorized access request");
			httpResponse.setStatus(403);
			httpResponse.sendRedirect("/UserManagerAPI/login.html");
		}else {
			//pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
	}
	/* Called before the Filter instance is removed from service by the web container */
	@Override
	public void destroy() {
		logger.info("Filter Destroyed");
		//Closing resources
	}
}
