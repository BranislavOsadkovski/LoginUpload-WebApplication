package com.usermanager.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig; 
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class SiteCounterFilter implements Filter {
	
	private static final Logger logger= Logger.getLogger(SiteCounterFilter.class);
	private int hitCount;
 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {  
		//Set the counter to 0
		logger.info("SiteCounterFilter initialized");
		this.hitCount=0;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		//increase counter
		hitCount++;
		//log the site count number
		logger.info("Site visits count: " + hitCount);
		//pass request back down the filter chain
		filter.doFilter(request, response);
		
	}
@Override
	public void destroy() {
	logger.info("SiteCounterFilter destroyed");
	logger.info("final site visits count:"+this.hitCount);
		/**Optional part depended on requirements of the application
		 * hitCount can be saved to database
		 * and updated from database the next time the filter is initialized
		 */
	}
}
