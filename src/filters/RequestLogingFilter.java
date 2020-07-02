package filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/RequestLogingFilter") You can use annotations or declare 
public class RequestLogingFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig fConfig) {
		// Filter will be initialized with initial method when the filter gets called the first time
		this.context = fConfig.getServletContext();
		this.context.log("RequestLogingFilter initialized");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Enumeration<String> params = httpRequest.getParameterNames();
		while (params.hasMoreElements()) {
			String name = params.nextElement();
			String value = request.getParameter(name);
			this.context.log(httpRequest.getRemoteAddr() + "::Request Params::{" + name + "=" + value + "}");

		}

		Cookie[] cookies = httpRequest.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				this.context.log(httpRequest.getRemoteAddr() + "::Cookie::{" + c.getName() + ":" + c.getValue() + "}");

			}
		}

		chain.doFilter(request, response);

	}
	/* Method is called before the Filter instance is removed from service by the web container*/
	@Override
	public void destroy() {
		// Here can close our resources
	}
}
