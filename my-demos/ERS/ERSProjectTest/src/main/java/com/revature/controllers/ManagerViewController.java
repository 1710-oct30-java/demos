package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ErsReimbursement;
import com.revature.beans.ErsUser;
import com.revature.beans.ersReimbursementStatus;
import com.revature.services.ManagerService;

public class ManagerViewController {
	private Logger log = Logger.getRootLogger();
	private ManagerService ms = new ManagerService();

	public String processPost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        if ("/users/manager/viewrequests/all".equals(actualURL)) {
        	log.debug("request to view all reimbursement recieved");
            return getAllRequests(request, response);
        } else if ("/users/manager/viewrequests/status".equals(actualURL)) {
        	log.debug("request to view reimbursement by status recieved");
        	return getRequestByStatus(request, response);
        }
		return null;
	}
	
	public String getAllRequests(HttpServletRequest request, HttpServletResponse response) {
		List<ErsReimbursement> allRequests = new ArrayList<>();
		ObjectMapper om = new ObjectMapper();
		
		allRequests = ms.getAllReimbursements();
		try {
			return om.writeValueAsString(allRequests);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getRequestByStatus(HttpServletRequest request, HttpServletResponse response) {
		List<ErsReimbursement> pendingReimbursements = new ArrayList<>();
		String json;
		try {
			log.debug("in getRequestByStatus()");
			json = request.getReader()
					.lines()
					.reduce((acc, cur) -> acc + cur)
					.get();
			log.trace("json received: " + json);

			
			ObjectMapper om = new ObjectMapper();
			ersReimbursementStatus status = om.readValue(json, ersReimbursementStatus.class);
			log.trace("reimbStatusId recived: " + status.getReimbStatusId());
			pendingReimbursements = ms.getStatusById(status.getReimbStatusId());
			return om.writeValueAsString(pendingReimbursements);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//call getByStatusId and just pass number corresponding to pending

}
