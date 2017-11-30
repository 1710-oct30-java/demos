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
import com.ers.services.ManagerService;
import com.ers.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ManagerController {

	private Logger log = Logger.getRootLogger();
	ManagerService ms = new ManagerService();
	UserService us = new UserService();
	
	/************************************** GET **************************************/
	public void delegateApprove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.debug("get request delegated to approve reimbursements controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(user.getRole_id() == 1) {
			request.getRequestDispatcher(actualURL + ".html").forward(request, response);
		}
		
		else {
			log.debug("User does not have access to this page!");
			log.debug("Redirecting to home...");
			response.sendRedirect("/ERS");
		}
	}
	
	
	public void delegateViewAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.debug("get request delegated to view all reimbursements controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());

		User user = (User) request.getSession().getAttribute("user");
		
		if(user.getRole_id() == 1) {
			request.getRequestDispatcher(actualURL + ".html").forward(request, response);
		}
		
		else {
			log.debug("User does not have access to this page!");
			log.debug("Redirecting to home...");
			response.sendRedirect("/ERS");
		}
	}
	/************************************** GET **************************************/
	
	
	
	/************************************** POST **************************************/
	public void delegatePost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if(actualURL.equals("/pages/reimbursements/approve")) {
			log.debug("post request delegated to update or deny reimbursement");
			approveDenyReimbursement(request, response);
		}
	}
	
	
	private void approveDenyReimbursement(HttpServletRequest request, HttpServletResponse response) {
        String json;
        try {
        	response.setHeader("success", "false");
        	log.debug("request to update reimbursement received");
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
            
            log.debug("Updating reimbursement...");
            if(ms.canApproveRequest(user, reimb)) {
            	ms.updateReimbursement(user, reimb, reimb.getR_status_id());
                response.setHeader("success", "true");
                response.setStatus(200);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
