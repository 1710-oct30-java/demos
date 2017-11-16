package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController
{
	public void delegateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/user".length());
		request.getRequestDispatcher("/static/index.html").forward(request, response);
		delegatePost(request,response);
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter writer = response.getWriter();
		writer.println(username);
		writer.println(password);
		
	}
}
