package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.beans.ErsReimbursement;
import com.revature.services.ErsReimbursementService;

public class ErsReimbursementController extends DefaultServlet {
	private Logger log = Logger.getRootLogger();
	private ErsReimbursementService rs = new ErsReimbursementService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        
		super.service(req, resp);
	}

	public void delegateGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request delegated to user controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/reimbursement".length());
		
		if("/all/".equals(actualURL) || "/all".equals(actualURL)) {
			// get all reimbursements
			List<ErsReimbursement> allReim = rs.getAllReim();
		} else if ("/getByUser/".startsWith(actualURL)) {
			rs.getByUserId(request, response);
		} else if ("/getNotMine/".startsWith(actualURL)) {
			rs.getNotMine(request, response);
		}
		
	}
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        if ("/reimbursement/new".equals(actualURL)) {
            rs.create(request, response);
            return;
        } else if ("/reimbursement/approve".equals(actualURL)) {
        	rs.approve(request, response);
        	return;
        } else if ("/reimbursement/deny".equals(actualURL)) {
        	rs.deny(request, response);
        	return;
        } 
	}

}
