package com.revature.controllers;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ErsReimbursement;
import com.revature.services.addReimbursementService;

public class AddReimbursementController {
	private Logger log = Logger.getRootLogger();
	addReimbursementService addReimbService = new addReimbursementService();
	private LocalDateTime now = LocalDateTime.now();
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) {
        String actualURL = request.getRequestURI().substring(request.getContextPath().length());
    }
    public void processPost(HttpServletRequest request, HttpServletResponse response) {
        String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        if ("/users/reimbursements/addreimbursement".equals(actualURL)) {
        	log.debug("request to add reimbursement recieved");
            addReimbursement(request, response);
            return;
        }
    }
    
    public void addReimbursement(HttpServletRequest request, HttpServletResponse response) {
    	String json;
    	try {
            // read the body of the request into a single string
            json = request.getReader() // get buffered reader for reading the request body
                    .lines() // stream the reader
                    .reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
                    .get(); // get that single string
            log.trace("json received: " + json);
            // convert the body of the request into an actual object
            ObjectMapper om = new ObjectMapper();
            ErsReimbursement reimb = om.readValue(json, ErsReimbursement.class);
            reimb.setReimbSubmitted(now);
            log.trace("reimbId received: " + reimb.getReimbId());
            log.trace("reimbAmount received: " + reimb.getReimbAmount());
            log.trace("reimbSubmitted set to: " + reimb.getReimbSubmitted());
            log.trace("reimbAuthor received: " + reimb.getReimbAuthor());
            log.trace("reimbStatusId received: " + reimb.getReimbStatusId());
            log.trace("reimbTypeId received: " + reimb.getReimbTypeId());
            
            
            addReimbService.addReimbursement(reimb);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
