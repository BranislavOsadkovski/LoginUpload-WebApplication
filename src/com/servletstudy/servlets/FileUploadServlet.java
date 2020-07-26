package com.servletstudy.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
	 SERVLET implementation class FileUploadServlet			
	 specify different size parameters for upload file 
 **/
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, 	    // 10 MB
				 maxFileSize = 1024 * 1024 * 50,			// 50 MB
				 maxRequestSize = 1024 * 1024 * 100)		// 100 MB

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isFileUploaded = false;
	private String fileExists = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServlet() {
		super();
	}

	private static String UPLOAD_DIR = null;
	private String username = null;
	/**Demonstrating a simple way to write a file to the server. 
	 * For FileUpload recommended to be used are 
	 * commons-fileupload.x.x.jar library 
	 * and
	 * commons-io-x.x.jar library
	 *  
	 */
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
		UPLOAD_DIR = request.getServletContext().getInitParameter("UPLOAD_DIR");
		request.setAttribute("fileExists",fileExists);
		
		if(request.getSession().getAttribute("user")!=null) {
			this.username=(String)request.getSession().getAttribute("user");
		}
		
		isFileUploaded=false;
		if(request.getSession().getAttribute("isFileUploaded")!=null) {
			isFileUploaded = (boolean) request.getSession().getAttribute("isFileUploaded");
		}
		if (!isFileUploaded) {
			String webApplicationPath = request.getServletContext().getRealPath("");
			String uploadFilePath = webApplicationPath + File.separator + UPLOAD_DIR;

			// Create the save directory if it does not exists
			File fileSaveDir = new File(uploadFilePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir(); 
				/**		I am using TOMCAT through eclipse so the path is different. 
				 * If I was using TOMCAT from CMD directory file path would be set as
				 * value of context parameter in web.xml 
				 * and accessed as ServletContext Initial Parameters 
				 *   
				 *<context-param> 
				 * 		<description>Location to store uploaded file</description> 
				 *  	<param-name>file-upload</param-name> 
				 *  	<param-value>
				 *     	  c:\apache-tomcat-5.5.29\webapps\data\
				 *  	</param-value> 
				 *</context-param>
				 */
			}
			System.out.println("Upload file directory PATH: " + fileSaveDir.getAbsolutePath()+ "\\");
			String fileName = null;

			/**
			 * 	Get all the parts from request and write it to the server
			 * 	go through all the parts of this request. The method getParts() returns a
			 * 	Collection<part> 
			 */
			
			for (Part part : request.getParts()) {
				fileName = getFileName(part);
				if(fileName.equals("") || fileName==null) {
				/**
				 * 			The ServletContext logs its text messages to the SERVLET container's log file. 
				 * 		With TOMCAT these logs are found in <Tomcat-installation-directory>/logs.
				 *		The log files do give an indication of new emerging bugs or the frequency of problems. 
				 *		It's good to use the log() function in the catch clause of exceptions 
				 *      which should normally not occur.
				 */					
					getServletContext().log("Missing parameter",new IllegalStateException("Missing parameter"));

					break;
				}
				if(fileName!="" || fileName!=null ) {
					
						File file = new File(fileSaveDir.getAbsolutePath()+ "\\"+this.username + File.pathSeparator + fileName);
						if(file.exists()) {
							fileExists="File with this name already exists on server";
							request.getSession().setAttribute("fileExists", fileExists);
						}else {
							part.write(fileSaveDir.getAbsolutePath()+ "\\"+this.username + File.pathSeparator + fileName);
							isFileUploaded = true;
						}
				
				}
			}
			
			
			request.getSession().setAttribute("isFileUploaded", isFileUploaded);
			response.sendRedirect("CheckoutPage.jsp");
		}

	}

}
