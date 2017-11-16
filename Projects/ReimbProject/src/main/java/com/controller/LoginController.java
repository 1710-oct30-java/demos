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
import com.services.UserService;

public class LoginController
{
	UserService us = new UserService();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// String actualURL =
		// request.getRequestURI().substring(request.getContextPath().length() +
		// "/user".length());
		request.getRequestDispatcher("/static/index.html").forward(request, response);
		// delegatePost(request,response);
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");

		PrintWriter writer = response.getWriter();
//		writer.println(username);
//		writer.println(password);
		List<User> allUsers = us.getAllUsers();

		ObjectMapper om = new ObjectMapper();
		ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(allUsers);

		writer.write(json);

	}
}
