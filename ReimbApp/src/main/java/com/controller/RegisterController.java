package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.beans.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.RegisterService;
import com.util.Password;

public class RegisterController
{
	Logger log = Logger.getRootLogger();
	RegisterService rs = new RegisterService();
	Password hashing = new Password();

	public void delegateGet(HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException
	{
		log.debug("get in Regctrl");

		request.getRequestDispatcher("/static/register.html").forward(request, response);

	}

	public void delegatePost(HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException, NoSuchAlgorithmException, NoSuchProviderException
	{
		// TODO Auto-generated method stub
		log.debug("post in Regctrl");
		register(request, response);
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws IOException, NoSuchAlgorithmException, NoSuchProviderException
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
			System.out.println(u);
			if (rs.usernameAvail(u))
			{
				log.debug("registering");
				String orgPassword = u.getPassword();
				byte[] salt = hashing.getSalt();
				String newPassword = hashing.getSecurePassword(orgPassword, salt);
				u.setPassword(newPassword);
				u.setSalt(salt);

				rs.newUser(u);
				log.debug("Reged Succeed");

			}
			else
			{
				log.debug("Reged Failed");
				response.setStatus(401);
			}

		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
		}

	}
}
