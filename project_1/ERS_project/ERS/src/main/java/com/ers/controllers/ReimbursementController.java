package com.ers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.beans.Reimbursement;
import com.ers.beans.User;
import com.ers.services.ManagerService;
import com.ers.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ReimbursementController {

	private Logger log = Logger.getRootLogger();
	UserService us = new UserService();
	ManagerService ms = new ManagerService();

	/************************************** GET **************************************/
	/**
	 * Get request delegated to reimbursement controller
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void delegateGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.debug("get request delegated to reimbursement controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if(validSession(request, response)) {
			request.getRequestDispatcher(actualURL + ".html").forward(request, response);
		}
	}
	
	public void delegateAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.debug("get request delegated to add reimbursement controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if(validSession(request, response)) {
			request.getRequestDispatcher(actualURL + ".html").forward(request, response);
		}
	}
	/************************************** GET **************************************/
	
	
	private boolean validSession(HttpServletRequest request, HttpServletResponse response) {

		boolean valid = true;

		try {
			User user = (User) request.getSession().getAttribute("user");

			if (user == null) {
				valid = false;
				log.debug("User has no access to this page!");
				log.debug("Redirecting to home...");
				response.sendRedirect("/ERS");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return valid;
	}
	
	
	/************************************** POST **************************************/
	
	public void delegatePost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if(actualURL.equals("/pages/reimbursements/add")) {
			log.debug("post request delegated to add reimbursement");
			addReimbursement(request, response);
		}
	}
	
	/**
	 * Add reimbursement to database.
	 * @param request
	 * @param response
	 */
	private void addReimbursement(HttpServletRequest request, HttpServletResponse response) {
        String json;
        try {
        	response.setHeader("success", "false");
        	log.debug("request to add reimbursement received");
        	User user = (User) request.getSession().getAttribute("user");
        	
            
            // read the body of the request into a single string
            json = request.getReader() // get buffered reader for reading the request body
                    .lines() // stream the reader
                    .reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
                    .get(); // get that single string
            
            log.trace("json received: " + json);
            
            // convert the body of the request into an actual object
            ObjectMapper om = new ObjectMapper();
            Reimbursement reimb = om.readValue(json, Reimbursement.class);
            log.trace("amount received: " + reimb.getR_amount());
            log.trace("type received: " + reimb.getR_type_id());
            log.trace("description received: " + reimb.getR_description());
            
            
            if(reimb.getR_amount() <= 0) {
            	log.debug("Amount cannot be zero or less! Reimbursement not added");
            }
            
            else {
            	log.debug("adding reimbursement...");
            	
            	// add reimbursement to database
                us.addReimbusement(user, reimb);					

                // Update user reimbursement that was just added 
                user.getReimbursements().remove(user.getReimbursements().size() - 1);
                user.getReimbursements().add(ms.getReimbursementById(ms.getIdOfLastReimbusement()));
                
                log.debug("reimbursement added!");
                response.setHeader("success", "true");
                response.setStatus(200);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
