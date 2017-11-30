package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.ErsReimbursement;

public class DispatcherServlet extends DefaultServlet {
	private Logger log = Logger.getRootLogger();
	
	private AddReimbursementController arc = new AddReimbursementController();
	private UserController uc = new UserController();
	private EmpViewPastReqsController ec = new EmpViewPastReqsController();
	private ManagerViewController mc = new ManagerViewController();
	
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        super.service(req, resp);
    }
	
	@Override  //allows us to serve static content
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        System.out.println(actualURL);
        if (actualURL.startsWith("/static")) {
            super.doGet(request, response);
            return;
        } else if(actualURL.startsWith("/users/login")) {
        	uc.processGet(request, response);
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        System.out.println(actualURL);
        
        PrintWriter out = response.getWriter();
        
        if (actualURL.startsWith("/users/login")) {
        	log.debug("request to login recieved.");
        	uc.processPost(request, response);
        	
        } else if (actualURL.startsWith("/users/reimbursements/addreimbursement")) {
            log.debug("reimbursement request recieved");
            arc.processPost(request, response);          
        } else if (actualURL.startsWith("/users/reimbursements/viewpastreimbursements")) {
        	log.debug("request to view past reimbursements recieved"); 
            out.write(ec.processPost(request, response));
        } else if (actualURL.startsWith("/users/manager/viewrequests/all")) {
        	log.debug("request to view requests recieved");       	
        	out.write(mc.processPost(request, response));
        } else if (actualURL.startsWith("/users/manager/viewrequests/status")) {
        	out.write(mc.processPost(request, response));
        }
    }

}
