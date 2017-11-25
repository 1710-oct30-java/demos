package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;

public class FrontController extends DefaultServlet {
	Logger log = Logger.getRootLogger();
	private LoginController lc = new LoginController();
	private ReimbursementController rc = new ReimbursementController();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String actualURL = request.getRequestURI().substring(request.getContextPath().length());

		log.debug("in FrontController : " + request.getRequestURI());
		if (actualURL.startsWith("/static")) {
			super.doGet(request, response);
			return;
		} else if ("/".equals(actualURL)) {
			// forward, the clients URL to login controller
			lc.delegateGet(request, response);
		
		} else if("/home".equals(actualURL)) {
			rc.delegateGet(request, response);
		}
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setHeader("Access-Control-Allow-Origin", "https://localhost:4200");
        response.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS, DELETE");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request made with url " + request.getRequestURI());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());

		if (actualURL.startsWith("/")) {
			lc.delegatePost(request, response);
		}

	}
}
