package com.ers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.beans.Reimbursement;
import com.ers.beans.User;
import com.ers.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class LoginController {
	
	private Logger log = Logger.getRootLogger();
	private UserService us = new UserService();
	
	/**
	 * Get request delegated to login controller
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void delegateGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.debug("get request delegated to login controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		request.getRequestDispatcher(actualURL + ".html").forward(request, response);
	}
	
	public void delegatePost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if(actualURL.equals("/pages/signin")) {
			login(request, response);
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
            
            if(!us.checkCredentials(u)) {
                response.setStatus(401);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/*
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Checking user credentials.....");
		if(us.checkCredentials(username, password)) {
			log.debug("Login successful!");
			
			// Log user information
			User user = new User();
			us.loginUser(user, username);
			
			request.getSession().setAttribute("user", user);
			
			// Redirect user to home page
			//response.sendRedirect("/ERS/home");
		}
		
		else {
			//response.sendRedirect("/ERS/pages/signin");
			response.setStatus(401);
		}
	}
	*/
}
