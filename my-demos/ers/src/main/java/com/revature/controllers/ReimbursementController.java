package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementCreator;
import com.revature.beans.ReimbursementResolution;
import com.revature.beans.User;
import com.revature.beans.UserLogin;
import com.revature.services.ReimbursementService;

public class ReimbursementController {
	private ReimbursementService rs = new ReimbursementService();
	private Logger log = Logger.getRootLogger();
	
	protected void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if(actualURL.equals("/reimbursements/")) {
			User u = (User) request.getSession().getAttribute("user");
			List<Reimbursement> output = rs.viewPastReimbursements(u.getUserID());
			log.trace(u.getUsername() + " " + u.getUserID());
			log.trace(output);
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(output);
			log.trace(json);
			PrintWriter writer = response.getWriter();
			writer.write(json);
			
			return;
		}
		else if(actualURL.equals("/reimbursements/all")) {
			User u = (User) request.getSession().getAttribute("user");
			if (u.getRoleID() == 1) {
				response.setStatus(401);
			}
			else {
				List<Reimbursement> output = rs.viewAllReimbursements();
				
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(output);
				PrintWriter writer = response.getWriter();
				writer.write(json);
				return;
			}
		}
	}
	protected void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if(actualURL.equals("/reimbursements/approve")) {
			User u = (User) request.getSession().getAttribute("user");
			if (u.getRoleID() == 1) {
				response.setStatus(401);
			}
			else {
				String json;
		    	try {
		    		json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		        	//log.debug("request to login received");
		        	log.trace("json received: " + json);
		        	ObjectMapper om = new ObjectMapper();
		        	ReimbursementResolution rr = om.readValue(json, ReimbursementResolution.class);
		        	log.trace("resolution object: " + rr);
		        	log.trace("status: " + rr.getStatus());
		        	
		        	log.trace(rs.approve(rr.getStatus(), u.getUserID()));
		        	if(rs.approve(rr.getStatus(), u.getUserID()) == true) {
		        		response.setStatus(200);
		        	}
		        	else {
		        		response.setStatus(401);
		        	}
		        	
		    	}
		    	catch(IOException e) {
		    		
		    	}
			}
		}
		else if(actualURL.equals("/reimbursements/deny")) {
			User u = (User) request.getSession().getAttribute("user");
			if (u.getRoleID() == 1) {
				response.setStatus(401);
			}
			else {
				String json;
		    	try {
		    		json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		        	//log.debug("request to login received"
		    		log.trace("json received: " + json);
		        	ObjectMapper om = new ObjectMapper();
		        	ReimbursementResolution rr = om.readValue(json, ReimbursementResolution.class);
		        	log.trace("resolution object: " + rr);
		        	log.trace("status: " + rr.getStatus());
		        	rs.deny(rr.getStatus(), u.getUserID());
		        	response.setStatus(200);
		    	}
		    	catch(IOException e) {
		    		
		    	}
			}
		}
		else if(actualURL.equals("/reimbursements/add")) {
			User u = (User) request.getSession().getAttribute("user");
			String json;
	    	try {
	    		json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
	        	//log.debug("request to login received"
	    		log.trace("json received: " + json);
	        	ObjectMapper om = new ObjectMapper();
	        	ReimbursementCreator rc = om.readValue(json, ReimbursementCreator.class);
	        	log.trace("resolution object: " + rc);
	        	rs.addReimbursement(rc.getAmount(), rc.getDescription(), null, u.getUserID(), 1, rc.getType());
	        	response.setStatus(200);
	    	}
	    	catch(IOException e) {
	    		
	    	}
			//u.getUserID();
		}
	}
}
