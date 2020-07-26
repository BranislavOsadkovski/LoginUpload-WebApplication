package com.servletstudy.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SiteCounterFilter implements Filter {
	
	
	private int hitCount;
	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		context =filterConfig.getServletContext();
		//Set the counter to 0
		this.hitCount=0;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		//increase counter
		hitCount++;
		//log the site count number
		this.context.log("Site visits count: " + hitCount);
		//pass request back down the filter chain
		filter.doFilter(request, response);
		
	}
@Override
	public void destroy() {
		/**Optional part depended on requirements of the application
		 * hitCount can be saved to database
		 * and updated from database the next time the filter is initialized
		 */
	}
}
