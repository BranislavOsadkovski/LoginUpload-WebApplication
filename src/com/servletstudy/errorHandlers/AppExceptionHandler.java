package com.servletstudy.errorHandlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SERVLET implementation class AppExceptionHandler
 */
@WebServlet("/AppExceptionHandler")
public class AppExceptionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processError(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processError(request,response);
	}
	
	//method that will process the exception thrown by the SERVLET
	private void processError(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//Analyze the exception
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		
		if(servletName==null) {
			servletName = "Unknown";
		}
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if(requestUri==null) {
			requestUri="Unknown";
			
		}
		/**Adapt the Client view and help him redirect back to application 
		 * OPTIONAL(Recommended) : Provide error report option to get the client feedback about the error/exception
		 */
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	      out.write("<html><head><title>Exception/Error Details</title></head><body>");
	      /**error type is checked if its internal server error or a code error**/
	      if(statusCode != 500){ 
	    	  out.write("<h3>Error Details</h3>");
	    	  out.write("<strong>Status Code</strong>:"+statusCode+"<br>");
	    	  out.write("<strong>Requested URI</strong>:"+requestUri);
	      }else{
	    	  /**code 500 throws a NullPointerException when calling Throwable.getClass() 
	    	  so error code must be checked when calling this method**/
	    	  out.write("<h3>Exception Details</h3>");
	    	  out.write("<ul><li>Servlet Name:"+servletName+"</li>");
	    	  out.write("<li>Exception Name:"+throwable.getClass().getName()+"</li>");
	    	  out.write("<li>Requested URI:"+requestUri+"</li>");
	    	  out.write("<li>Exception Message:"+throwable.getMessage()+"</li>");
	    	  out.write("</ul>");
	       }  
	      out.write("<br><br>");
	      out.write("<a href=\"ServletStudyFilterTest/CheckoutPage.jsp\">Home Page</a>");
	      out.write("</body></html>");
	}
}
