package filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) {
		filterConfig.getServletContext().log("LogFilter initialized");
		
		//Getting initial parameter from web.xml file
		String testParam = filterConfig.getInitParameter("test-param");
		//Notification marker
		System.out.println("test param : " + testParam);
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//Get the IP Address of client machine
		String ipAddress = request.getRemoteAddr();
		
		//Log the IP address and time
		System.out.println("Client ip : " + ipAddress + " / Time : " + new Date().toString());
		
		//passing request down the filter chain
		chain.doFilter(request, response);
		
	}
	
	/* Called before the Filter instance is removed from service by the web container*/
	@Override
	public void destroy() {
		//Close resources
	}

}
