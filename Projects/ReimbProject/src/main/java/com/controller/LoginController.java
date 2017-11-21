package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.beans.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.LoginService;
import com.services.UserService;

public class LoginController
{
	Logger log = Logger.getRootLogger();
	UserService us = new UserService();
	LoginService ls = new LoginService();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		log.debug("get in loginctrler");
		// String actualURL =
		// request.getRequestURI().substring(request.getContextPath().length());
		// System.out.println(actualURL);
		// String actualURL =
		// request.getRequestURI().substring(request.getContextPath().length() +
		// "/user".length());
		request.getRequestDispatcher("/static/login.html").forward(request, response);
		// delegatePost(request,response);
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		log.debug("Post Request To Do Login received");
		PrintWriter writer = response.getWriter();
		login(request, response);

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		try
		{
			// String username = request.getParameter("username").toLowerCase();
			// String password = request.getParameter("password");

			// if (ls.validate(username, password))
			// {
			/*
			 * getReader() get bufferd reader for reading the request body lines() stream
			 * the reader reduce() create a stream acc points at first line, cur points at
			 * next line add acc and cur together, cur moves to next line .get() get the
			 * result
			 */
			// List<User> allUsers = us.getAllUsers();
			String json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
			ObjectMapper om = new ObjectMapper();
			/*----------Get JSON contents into USER class
			*
			* from postman: { "username" : "randy", "password" : "1234" }
			*/
			User u = om.readValue(json, User.class);
			// ObjectWriter ow = om.writer().withDefaultPrettyPrinter();

			if (!ls.validate(u.getUsername(), u.getPassword()))
			{
				response.setStatus(401);
			}
			else
			{
				log.debug("logged in");
				request.getSession().setAttribute("loggedIn", true);

			}

			// String json = ow.writeValueAsString(allUsers);

			// writer.write(json);
			// }
			// else
			// {
			// response.sendRedirect("/ReimbProject/login");
			// }
		}
		catch (NullPointerException e)
		{
			// response.sendRedirect("/ReimbProject/login");
		}
	}
}
