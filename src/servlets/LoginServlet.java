package servlets;

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

/**
 * SERVLET implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String basePassword = "tomcat";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		//Also check username in the database matching the password
		if (password.equals(basePassword)) {
				response.getWriter().write(username + password);
				//Getting session object created
				HttpSession session = request.getSession();
				//adding user to session as session attribute
				session.setAttribute("user", username); 
				//setting session to expire in 30 min
				session.setMaxInactiveInterval(30*60);
				//Creating Cookie
				Cookie userCookie = new Cookie("user",username);
				userCookie.setMaxAge(30*60);
				//add cookie to response and send redirect to .jsp page
				response.addCookie(userCookie);
				//Adding User Attribute to ServletContext
				servletCtx.setAttribute("User", username);
				
				response.sendRedirect("LoginSuccess.jsp");
			 
			} else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
				response.getWriter().print("<font color=red>Either user name or password is wrong.</font>");
				rd.include(request, response);
			}

	}

}
