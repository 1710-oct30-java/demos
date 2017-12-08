package com.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.beans.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.LoginService;

public class LoginController
{
	Logger log = Logger.getRootLogger();
	LoginService ls = new LoginService();

	public void delegateGet(HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException
	{
		log.debug("get in loginctrl");

		request.getRequestDispatcher("/static/login.html").forward(request, response);

	}

	public void delegatePost(HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		log.debug("post in loginctrl");
		login(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		StringBuffer jb = new StringBuffer();
		String line = null;
		try
		{
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
			{
				jb.append(line);
			}
			reader.close();
			ObjectMapper om = new ObjectMapper();
			User u = om.readValue(jb.toString(), User.class);
			User result = ls.checkUser(u);
			if (result == null)
			{
				response.setStatus(401);
			}
			else
			{
				log.debug("logged in");
				request.getSession().setAttribute("user", result);
				if (result.getRoleId() == 1)
				{
					response.setStatus(200);
				}
				else if (result.getRoleId() == 2)
				{
					response.setStatus(201);
				}

			}

		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
		}

	}

}
