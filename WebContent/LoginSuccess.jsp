<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		//Allow access only if session exists
	String session_cookie = null;
	String username_cookie = null;
	String user = null;
	Date date = new Date();
	if (session != null) {
		user = (String) session.getAttribute("user");
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length != 0) {
			for (Cookie c : cookies) {
		if (c.getName().equals("user"))username_cookie = c.getValue();
		if (c.getName().equals("JSESSIONID"))session_cookie = c.getValue();
			}
		}

	} else {
		//send redirect login.jsp or error code 403 Forbiden
	}
	%>
	<h3>
		Hi
		<font color=red> <%=username_cookie%> </font>, Login succesfull. Your session ID =
		<%=session_cookie%></h3><br> 
		<%=date %><br> 
		
		<%/**For auto refresh and to update data or time in this case 
		we can use the method response.setIntHeader */ 
		response.setIntHeader("Refresh", 1); %>
	User =	<%=user%>
	<br>
	<a href="CheckoutPage.jsp">Checkout Page</a>
	<p></p><br>
	<form action="LogoutServlet" method="post"> 
		<input type="submit" value="Logout">
	</form>
</body>
</html>