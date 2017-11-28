package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.User;
import com.revature.exceptions.InvalidCredentialException;
import com.revature.services.UserService;

public class UserController
{
	private Logger		log	= Logger.getRootLogger();
	private UserService	us	= new UserService();
	
	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
	{
		log.debug("Get request has been delegated to user controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/user".length());
		
		if (actualURL.equals("/") || actualURL.equals(""))
		{
			try
			{
				// get all of the users from the service
				List<User> allUsers = us.getAll();
				
				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(allUsers);
				
				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);
				
				log.debug("wrote users to body of the response");
				return;
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void delegatePost(HttpServletRequest request, HttpServletResponse response) throws InvalidCredentialException
	{
		log.debug("get request delegated to user controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/login".length());
		
		if (actualURL.equals(""))
		{
			try
			{
				String json = request.getReader() // get the buffered reader
						.lines() // stream it
						.reduce((acc, cur) -> acc + cur) // reduce it to a single value
						.get(); // get that single value
				log.trace("json received = " + json);
				ObjectMapper om = new ObjectMapper();
				User u = om.readValue(json, User.class);
				log.trace("object created from json = " + u);
				
				u = us.login(u);
				
				if (u != null)
					log.debug(u + " has logged in.");
				else
					throw new InvalidCredentialException(401);
			}
			catch (JsonParseException e)
			{
				e.printStackTrace();
			}
			catch (JsonMappingException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
