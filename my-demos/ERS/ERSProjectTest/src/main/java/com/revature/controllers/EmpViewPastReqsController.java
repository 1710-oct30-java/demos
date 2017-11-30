package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ErsReimbursement;
import com.revature.beans.ErsUser;
import com.revature.services.ViewPastService;

public class EmpViewPastReqsController {
	
	private Logger log = Logger.getRootLogger();
	private ViewPastService vs = new ViewPastService();

	public String processPost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        if ("/users/reimbursements/viewpastreimbursements".equals(actualURL)) {
        	log.debug("in processPost() EmpViewPastReqsController");
        	return getPastByUserId(request, response);
        }
        return null;
	}
	
	private String getPastByUserId(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<ErsReimbursement> past = new ArrayList<>();
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
			log.trace("ersUserId recived: " + u.getErsUserId());
			past = vs.getPastById(u);
			return om.writeValueAsString(past);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
