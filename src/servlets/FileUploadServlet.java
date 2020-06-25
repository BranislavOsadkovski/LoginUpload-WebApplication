package servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * SERVLET implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")    					/** specify different size parameters for upload file **/
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, 	// 10 MB
		maxFileSize = 1024 * 1024 * 50,					// 50 MB
		maxRequestSize = 1024 * 1024 * 100)				// 100 MB
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isFileUploaded = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final String UPLOAD_DIR = "uploads";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**This is just one way to write a file to the server. For FileUpload you can also use 
	 * commons-fileupload.x.x.jar library 
	 * and
	 * commons-io-x.x.jar library
	 *  **/
	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("content-disposition header= " + contentDisp);
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get absolute path of the web application
		boolean FileUploaded=false;
		if(request.getSession().getAttribute("isFileUploaded")!=null) {
		FileUploaded = (boolean) request.getSession().getAttribute("isFileUploaded");
		}
		if (!FileUploaded) {
			String webApplicationPath = request.getServletContext().getRealPath("");
			String uploadFilePath = webApplicationPath + File.separator + UPLOAD_DIR;

			// Create the save directory if it does not exists
			File fileSaveDir = new File(uploadFilePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir(); 
				/**		I am using Tomcat through eclipse so the path is different if you were to use Tomcat from cmd
				 * set your file path as shown in the example, there is also another way that
				 * you can set your directory in web.xml and access it as ServletContext Initial Parameters the same way   
				 * shown in WebListener -> AppContextListener 
				 *   
				 *<context-param> 
				 * 		<description>Location to store uploaded file</description> 
				 *  	<param-name>file-upload</param-name> 
				 *  	<param-value>
				 *     	  c:\apache-tomcat-5.5.29\webapps\data\
				 *  	</param-value> 
				 *</context-param>
				 */
				System.out.println("Upload file directory PATH: " + fileSaveDir.getAbsolutePath());
			}
			String fileName = null;

			// Get all the parts from request and write it to the server
			/**
			 * go through all the parts of this request. The method getParts() returns a
			 * Collection<part>
			 **/
			for (Part part : request.getParts()) {
				fileName = getFileName(part);
				part.write(uploadFilePath + File.pathSeparator + fileName);

			}
			isFileUploaded = true;
			
			request.getSession().setAttribute("isFileUploaded", isFileUploaded);
			response.sendRedirect("CheckoutPage.jsp");
		}

	}

}
