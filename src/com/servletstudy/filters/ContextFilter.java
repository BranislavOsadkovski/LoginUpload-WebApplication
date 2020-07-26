package com.servletstudy.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter
public class ContextFilter implements Filter{
	static ServletContext context=null;
	
	@Override
	public void init(FilterConfig filterConfig) {
		context = filterConfig.getServletContext();
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
	
	}
	public static ServletContext getServletContext() {
		return context;
	}
	
}
