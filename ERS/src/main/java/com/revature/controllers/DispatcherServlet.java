package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.controllers.ErsReimbursementController;
import com.revature.controllers.ErsUserController;
import com.revature.services.ErsUserService;

public class DispatcherServlet extends DefaultServlet {
	private Logger log = Logger.getRootLogger();
	private ErsUserService us = new ErsUserService();
	private ErsUserController uc = new ErsUserController();
	private ErsReimbursementController rc = new ErsReimbursementController();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		
		if (actualURL.startsWith("/static/")) {
			super.doGet(request, response);
			return;
		} else if(actualURL.startsWith("/user/")) {
			uc.delegateGet(request, response);
		} else if(actualURL.startsWith("/reimbursement/")) {
			rc.delegateGet(request, response);
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        System.out.println(actualURL);
        
        if (actualURL.startsWith("/users/")) {
            uc.processPost(request, response);
        } else if (actualURL.startsWith("/reimbursement/")) {
        	rc.processPost(request, response);
        }
    }
}
