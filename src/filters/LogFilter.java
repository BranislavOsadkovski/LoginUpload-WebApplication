package filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/LogFilter")
/**Placed annotation in LogFilter to simulate the initialization by annotation
 so you can see that the Filter is initialized two times: 
 First time by annotation && Second time by web.xml file so we can see from the marker the first time 
 initial parameter will be null
**/
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
		//Here we can close resources
	}

}
