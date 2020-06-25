package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RespServlet
 */
@WebServlet("/RespServlet")
public class RespServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RespServlet() {
        super();
      
        // TODO Auto-generated constructor stub
    }
    
    
	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Returns request Context Path 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(password.equals("tomcat")) {
		System.out.print("Username : " + username);
		System.out.print("Password : " + password);
		response.setStatus(200);
		response.getWriter().append("Logged in");
		}else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().append("forbiden");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Returns unsupported media type
		response.setStatus(response.SC_UNSUPPORTED_MEDIA_TYPE);
		response.getWriter().append("Unsupported media type POST bankai");
	}

}
