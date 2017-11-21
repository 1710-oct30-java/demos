package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.services.UserService;

public class UserController {
	private Logger log = Logger.getRootLogger();
	private UserService us = new UserService();

	public void processGet(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
	}

	public void processPost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if ("/users/login".equals(actualURL)) {
			login(request, response);
			return;
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			log.debug("request to login received");

			// read the body of the request into a single string
			json = request.getReader() // get buffered reader for reading the request body
					.lines() // stream the reader
					.reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
					.get(); // get that single string
			log.trace("json received: " + json);

			// convert the body of the request into an actual object
			ObjectMapper om = new ObjectMapper();
			User u = om.readValue(json, User.class);
			log.trace("username received: " + u.getUsername());
			log.trace("password received: " + u.getPassword());

			// call the user service to try loggin in
			User actualUser = us.login(u);
			if(actualUser == null) {
				response.setStatus(401);
			} else {
				request.getSession().setAttribute("user", actualUser);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
