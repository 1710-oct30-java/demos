package com.revature.controllers;

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
import com.revature.beans.Users;
import com.revature.services.UserService;

public class UserController {

	private Logger log = Logger.getRootLogger();
	private UserService us = new UserService();

	public void delegateDelete(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if ("/reimbursement".equals(actualURL)) {
			logout(request, response);
		}
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if ("/home/login".equals(actualURL)) {
			login(request, response);
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		log.trace(request.getSession().getAttribute("user"));
		request.getSession().removeAttribute("user");
		log.trace(request.getSession().getAttribute("user"));
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
            Users u = om.readValue(json, Users.class);
            log.trace("username received: " + u.getUsername());
            log.trace("password received: " + u.getPassword());
            Users actualUser = us.login(u);
            if(actualUser == null) {
                response.setStatus(401);
            } else {
            	log.trace("login successful");
            	request.getSession().setAttribute("user", actualUser);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
