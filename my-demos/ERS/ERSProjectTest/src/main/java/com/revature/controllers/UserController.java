package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.LoginService;

import com.revature.beans.ErsUser;

public class UserController {
	
	private Logger log = Logger.getRootLogger();
	private LoginService ls = new LoginService();
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) {
        String actualURL = request.getRequestURI().substring(request.getContextPath().length());
    }
    public void processPost(HttpServletRequest request, HttpServletResponse response) {
        String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        if ("/users/login".equals(actualURL)) {
        	log.debug("in processPost() in UserController");
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
			ErsUser u = om.readValue(json, ErsUser.class);
			log.trace("username received: " + u.getErsUsername());
			log.trace("password received: " + u.getErsPassword());

			// call the user service to try logging in
			ErsUser actualUser = ls.login(u);
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
