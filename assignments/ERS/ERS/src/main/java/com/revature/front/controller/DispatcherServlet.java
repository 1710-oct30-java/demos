package com.revature.front.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;

@SuppressWarnings("serial")
public class DispatcherServlet extends DefaultServlet {
	private UserController uc = new UserController();
	private ReimbursementController rc = new ReimbursementController();
	
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        super.service(req, resp);
    }
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualUrl = request.getRequestURI().substring(request.getContextPath().length());

		if (actualUrl.startsWith("/static")) {
			super.doGet(request, response);
			return;
		}

		if ("/home".equals(actualUrl)) {

			// In a forward, the client's url does not change, and the client is not aware
			// it was forwarded.
			request.getRequestDispatcher("/static/index.html").forward(request, response);

			// In a redirect, the client's url DOES change, and the client is aware it was
			// redirected.
			// response.sendRedirect("/FrontController/static/index.html");
		}
		
		if (actualUrl.startsWith("/user")) {
			System.out.println("user request");
			uc.delegateGet(request, response);
		}
		
		if (actualUrl.startsWith("/reimbursements")) {
			System.out.println("reimb request");
			rc.delegateGet(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualUrl = request.getRequestURI().substring(request.getContextPath().length());
		if (actualUrl.startsWith("/reimbursements")) {
			System.out.println("reimb request");
			rc.delegatePost(request, response);
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actualUrl = request.getRequestURI().substring(request.getContextPath().length());
		if (actualUrl.startsWith("/reimbursements")) {
			
			rc.delegatePut(request, response);
		}
	}
}
