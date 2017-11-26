package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.exceptions.ErsHttpException;

public class FrontController extends DefaultServlet {
	private static final long serialVersionUID = 4540043774461730224L;
	private static Logger log = Logger.getRootLogger();

	private ReimbRequestController reimbController = new ReimbRequestController();
	private LoginController loginController = new LoginController();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.info("GET RECEIVED IN FRONT CONTROLLER");

		String uri = request.getRequestURI().toLowerCase();
		String destination = uri.substring(request.getContextPath().length() + 1, uri.length());

		try {
			if (destination.startsWith("home")) {
				request.getRequestDispatcher("index.html").forward(request, response);
			}

			else if (destination.startsWith("login") || destination.startsWith("logout")) {
				loginController.delegateGet(request, response);
			}

			else if (destination.startsWith("fetch")) {
				reimbController.delegateGet(request, response);
			}

			else {
				super.doGet(request, response);
			}
		} catch (ErsHttpException e) {
			response.setStatus(e.getStatusCode());
			log.warn("ERS Error has occurred: " + e.toString());
			request.getRequestDispatcher("./errors/" + e.getStatusCode() + ".html").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.info("POST RECEIVED IN FRONT CONTROLLER FROM: " + request.getRequestURI());

		String uri = request.getRequestURI().toLowerCase();
		String destination = uri.substring(request.getContextPath().length() + 1, uri.length());

		log.info("POST DESTINATION: " + destination);

		try {
			if (destination.startsWith("login")) {
				loginController.delegatePost(request, response);
			}

			else if (destination.startsWith("fetch")) {
				reimbController.delegatePost(request, response);
			}

			else {
				super.doGet(request, response);
			}
		} catch (ErsHttpException e) {
			response.setStatus(e.getStatusCode());
			log.warn("ERS Error has occurred: " + e.toString());
			super.doGet(request, response);
		}

		// reimbController.delegatePost(request, response);
	}
}
