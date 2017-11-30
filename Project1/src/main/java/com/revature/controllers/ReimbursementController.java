package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.Reimbursement;
import com.revature.beans.Users;
import com.revature.services.ReimbursementServices;

public class ReimbursementController {

	private Logger log = Logger.getRootLogger();
	private ReimbursementServices reimbService = new ReimbursementServices();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if ("/reimbursement".equals(actualURL)) {
			log.debug("getting all reimbursements");
			getAllReimbursements(request, response);
		}
		else if ("/userReimbursement".equals(actualURL)) {
			log.debug("getting user reimbursements");
			getUserReimbursements(request, response);
		}
		else {
			log.debug("delegateGet failed");
		}
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if ("/reimbursement".equals(actualURL)) {
			log.debug("Attempting to add reimbursements");
			addReimbursement(request, response);
	}
	} 
	
	public void delegatePut(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if ("/reimbursement".equals(actualURL)) {
			log.debug("Attempting to resolve a reimbursement");
			resolveReimbursement(request, response);
	}
	}
	
	private void getUserReimbursements(HttpServletRequest request, HttpServletResponse response) {
        try {
        	// get all of the pending reimbursements from the service
        	Users u = (Users) request.getSession().getAttribute("user");
        	List<Reimbursement> user_reimbursements = reimbService.getAllUserReimbursements(u);
			// convert arraylist to json
        	log.debug("convert reimbursements to json");
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(user_reimbursements);
			
			// write json to the body of the response
			log.debug("attempting to write json to the body of the response");
			PrintWriter writer = response.getWriter();
			writer.write(json);
			
			log.debug("wrote reimbursements to body of the response");
			return;
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	private void getAllReimbursements(HttpServletRequest request, HttpServletResponse response) {
        try {
        	// get all of the pending reimbursements from the service
        	Users u = (Users) request.getSession().getAttribute("user");
        	if (u.getUser_role_id() == 1 || u.getUser_role_id() == 2) {
        	List<Reimbursement> reimbursements = reimbService.getAllReimbursements();
			// convert arraylist to json
        	log.debug("convert reimbursements to json");
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(reimbursements);
			
			// write json to the body of the response
			log.debug("attempting to write json to the body of the response");
			PrintWriter writer = response.getWriter();
			writer.write(json);
			
			log.debug("wrote reimbursements to body of the response");
			return;
        	}
        	else {
        		log.info("Only managers may look at all reimbursements");
        		return;
        	}
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
	
	private void addReimbursement(HttpServletRequest request, HttpServletResponse response) {
        String json;
        try {
            log.debug("request to add reimbursement received");
            // read the body of the request into a single string
            json = request.getReader() // get buffered reader for reading the request body
                    .lines() // stream the reader
                    .reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
                    .get(); // get that single string
            log.trace("json received: " + json);
            // convert the body of the request into an actual object
            ObjectMapper om = new ObjectMapper();
            Reimbursement newReimb = om.readValue(json, Reimbursement.class);
            Users u = (Users) request.getSession().getAttribute("user");
            log.trace("username received: " + u.getUsername());
            log.trace("Amount received: " + newReimb.getReimb_amount());
            log.trace("Description received: " + newReimb.getReimb_description());
            log.trace("typeId received: " + newReimb.getReimb_type_id());
            reimbService.requestReimbursement(u, newReimb);
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	private void resolveReimbursement(HttpServletRequest request, HttpServletResponse response) {
        String json;
        try {
            log.debug("request to resolve reimbursement received");
            // read the body of the request into a single string
            json = request.getReader() // get buffered reader for reading the request body
                    .lines() // stream the reader
                    .reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
                    .get(); // get that single string
            log.trace("json received: " + json);
            // convert the body of the request into an actual object
            ObjectMapper om = new ObjectMapper();
            Reimbursement newReimb = om.readValue(json, Reimbursement.class);
            Users u = (Users) request.getSession().getAttribute("user");
            log.trace("username received: " + u.getUsername());
            log.trace("ReimbursementID received: " + newReimb.getReimb_id());
            log.trace("Reimbursement Status ID received: " + newReimb.getReimb_status_id());
            reimbService.resolve(u, newReimb);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
}
