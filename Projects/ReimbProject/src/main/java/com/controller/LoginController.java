package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.services.LoginService;
import com.services.UserService;

public class LoginController
{
	UserService us = new UserService();
	LoginService ls = new LoginService();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// String actualURL =
		// request.getRequestURI().substring(request.getContextPath().length() +
		// "/user".length());
		request.getRequestDispatcher("/static/login.html").forward(request, response);
		// delegatePost(request,response);
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		PrintWriter writer = response.getWriter();
		try
		{
			String username = request.getParameter("username").toLowerCase();
			String password = request.getParameter("password");

			if (ls.validate(username, password))
			{
				List<User> allUsers = us.getAllUsers();
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(allUsers);

				writer.write(json);
			}
			else
			{
				response.sendRedirect("/ReimbProject/login");
			}
		}
		catch (NullPointerException e)
		{
			response.sendRedirect("/ReimbProject/login");
		}
	}
}
