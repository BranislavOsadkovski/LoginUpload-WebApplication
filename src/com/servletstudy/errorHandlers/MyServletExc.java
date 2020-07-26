package com.servletstudy.errorHandlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SERVLET implementation class ServletException
 */
@WebServlet("/MyServletExc")
public class MyServletExc extends HttpServlet {
	private static final long serialVersionUID = 1L;
     // Testing ExceptionHandler by throwing a new exception
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Testing the ExceptionHandler
		throw new ServletException("GET Method Not Supported for Servlet" + request.getClass());
		
	}
	
	// Testing ExceptionHandler by throwing a new exception
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		throw new ServletException("POST Method Not Supported for Servlet" + request.getClass());
	}

}
