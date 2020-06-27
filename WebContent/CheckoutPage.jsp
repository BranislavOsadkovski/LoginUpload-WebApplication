<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login success page</title>
</head>
<body>
	<%
	
	boolean isFileUploaded=false;
	//check if the file has been uploaded already
	if(request.getSession().getAttribute("isFileUploaded")!=null){
	isFileUploaded= (boolean)request.getSession().getAttribute("isFileUploaded");
	}
	
	String username = null;
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie c : cookies) {
			if (c.getName().equals("user"))username = c.getValue();
		}
	}
	%>
	<h3>
		Hi <font color=red><%=username%></font> do the checkout.
	</h3>
	<br>
	
	<form action="FileUploadServlet" method="POST" enctype="multipart/form-data">
		<%if(!isFileUploaded){ %><input type="file" name="file" value="Load file"/> 
		<br>
		<input type="submit" value="Upload"/>
		<%}else{ %>
			<font color=green>File Uploaded</font> 
		<%} %>
	</form>
	
	<form action="LogoutServlet" method="POST">
		<input type="submit" value="Logout" />
	</form>

</body>
</html>