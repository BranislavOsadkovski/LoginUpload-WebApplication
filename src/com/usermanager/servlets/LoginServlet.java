package com.usermanager.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * SERVLET implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(LoginServlet.class); 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletCtx = request.getServletContext();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String attributePassword=(String) request.getServletContext().getAttribute("password");
		//Check username in the database matching the password
		if (password.equals("password")) {
			
				response.getWriter().write(username + password);
				logger.info("User LOGGED IN {username:"+username);
				//Getting session object created
				HttpSession session = request.getSession();
				
				//adding user to session as session attribute
				session.setAttribute("user", username); 
				
				//setting session to expire in 30min
				session.setMaxInactiveInterval(30*60);
				
				//Create Cookie
				Cookie userCookie = new Cookie("user",username);
				userCookie.setMaxAge(30*60);
				response.addCookie(userCookie);
				
				//Adding User Attribute to ServletContext
				servletCtx.setAttribute("User", username);
				
				response.sendRedirect("LoginSuccess.jsp");
			 
			} else {
				logger.info("Fail Login Attempt username:"+username);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
				response.getWriter().print("<font color=red>Either user name or password is wrong.</font>");
				rd.include(request, response);
			}

	}

}
