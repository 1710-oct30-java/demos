package com.ers.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.beans.User;
import com.ers.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public void delegateLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.debug("get request delegated to logout");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		request.getSession().invalidate();
		log.debug("session removed!");
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
        	response.setHeader("success", "false");
            log.debug("request to login received");
            
            // read the body of the request into a single string
            json = request.getReader() // get buffered reader for reading the request body
                    .lines() // stream the reader
                    .reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
                    .get(); // get that single string
            
            log.trace("json received: " + json);
            
            // convert the body of the request into an actual object
            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(json, User.class);
            log.trace("username received: " + user.getUsername());
            log.trace("password received: " + user.getPassword());
            
            if(us.checkCredentials(user)) {
            	user = us.getUserFromCredentials(user.getUsername());
            	user.getReimbursements().addAll(us.getReimbursementsByUser(user));
            	log.debug("Creating session...");
                HttpSession session = request.getSession();
                
                session.setAttribute("user", user);
                
                log.debug("Session created.");
                
                //setting session to expire in 30 minutes
    			session.setMaxInactiveInterval(30*60);
    			
    			response.setHeader("firstName", user.getFirstName());
    			response.setHeader("sessionValid", "true");
    			response.setHeader("role", "" + user.getRole_id());
    			response.setHeader("success", "true");
    			log.debug("Login successful!");
            }
            else {
            	response.setStatus(401);
            }
        } catch (IOException e) {
        	response.setHeader("success", "connection-issue");
            e.printStackTrace();
        }
    }
	
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		log.debug("Removing user session...");
		request.getSession().invalidate();
		log.debug("User logged off!");
	}
}
