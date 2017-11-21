<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In Controller</title>
</head>
<body>
	<%@page import="com.ers.servlets.LoginServlet"%>

	<%
		// If validSession is null, redirect to main page
		if (session.getAttribute("validSession") == null) {
			response.sendRedirect("/ERS/index.jsp");
		}

		// Redirect to main page if session is valid
		if (session.getAttribute("validSession").equals(true)) {
			response.sendRedirect("/ERS/index.jsp");
		}

		boolean status = LoginServlet.checkCredentials(request.getParameter("username"), request.getParameter("password"));
		
		if (status) {
			out.println("Login correct!");
			session.setAttribute("validSession", true);
			response.sendRedirect("/EdelPhotography");
			session.setAttribute("username", request.getParameter("username"));
		} else {
			out.println("Incorrect login!!");
			session.setAttribute("message", "Incorrect login!!");
			session.setAttribute("validSession", false);
			response.sendRedirect("login.jsp");
		}
	%>

</body>
</html>