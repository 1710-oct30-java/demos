package com.revature.front.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import com.revature.exceptions.UrlNotFoundException;
import com.revature.services.ReimbursementServices;
import com.revature.services.UserService;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends DefaultServlet {

	private Logger log = Logger.getRootLogger();
	private ReimbursementController rc = new ReimbursementController();
	private ReimbursementServices rserv = new ReimbursementServices();
	private UserController uc = new UserController();
	private UserService us = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		System.out.println("get request made with url" + request.getRequestURI());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());

		if (actualURL.startsWith("/static")) {
			super.doGet(request, response);
			return;
		} 

		else if (actualURL.startsWith("/reimbursement")) {
			log.debug("attempting to retrieve reimbursements");
			rc.delegateGet(request, response);
		} 
		
		else if (actualURL.startsWith("/userReimbursement")) {
			log.debug("attempting to retrieve user reimbursements");
			rc.delegateGet(request, response);
		} 
		
		else {
			log.warn("failed");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	
			System.out.println("post request made with url" + request.getRequestURI());
			String actualURL = request.getRequestURI().substring(request.getContextPath().length());
			

			if (actualURL.startsWith("/home/")) {
				log.debug("attempting login");
				uc.delegatePost(request, response);
			} 
			else if (actualURL.startsWith("/reimbursement")) {
				log.debug("attempting to add a reimbursement");	
				rc.delegatePost(request, response);
			} 
//			else {
//				throw new UrlNotFoundException();
			}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post request made with url" + request.getRequestURI());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if (actualURL.startsWith("/reimbursement")) {
			log.debug("attempting approve or deny method");
			rc.delegatePut(request, response);
		} 
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post request made with url" + request.getRequestURI());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if (actualURL.startsWith("/reimbursement")) {
			log.debug("attempting sign out");
			uc.delegateDelete(request, response);
		} 
	}
	}
