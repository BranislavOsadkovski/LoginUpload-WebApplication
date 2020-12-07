package com.usermanager.servlets;

import java.io.IOException;

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
 * SERVLET implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger logger = Logger.getLogger(LogoutServlet.class); 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			ServletContext servletContext = request.getServletContext();
			Cookie [] cookies = request.getCookies();
			Cookie JSESSIONID=null;
			Cookie userCookie =null;
			if(cookies!=null) {
				for(Cookie c : cookies) {
					//find remaining cookies in browser
					if(c.getName().equals("JSESSIONID"))JSESSIONID = c;
					if(c.getName().equals("user"))userCookie=c;
				}
			}

			//Invalidate session if exists
			HttpSession session = request.getSession(false);

			logger.info("  User = " + session.getAttribute("user") +"Loggin OUT");
			logger.info("Invalidating session for User = " + session.getAttribute("user"));
			if(session!=null) {
				session.invalidate(); 
			}
			//Remove Attribute from ServletContext
			servletContext.removeAttribute("User");
			//Deleting Cookies from browser by setting expiration time to zero
			JSESSIONID.setMaxAge(0);
			userCookie.setMaxAge(0);
			logger.info("deletting session cookie");
			logger.info("deleting user cookie");
			
			response.addCookie(JSESSIONID);
			response.addCookie(userCookie);
			response.sendRedirect("login.html");
	}

}
