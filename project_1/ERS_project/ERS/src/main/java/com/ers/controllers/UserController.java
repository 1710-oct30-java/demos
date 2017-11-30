package com.ers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.ers.beans.Reimbursement;
import com.ers.beans.User;
import com.ers.services.ManagerService;
import com.ers.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class UserController {

	private Logger log = Logger.getRootLogger();
	UserService us = new UserService();
	ManagerService ms = new ManagerService();

	/**
	 * Get request delegated to user controller
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("get request delegated to user controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		request.getRequestDispatcher(actualURL + ".html").forward(request, response);
	}

	public void delegateGetData(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("get request delegated to data controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		// request.getRequestDispatcher(actualURL + ".html").forward(request, response);

		if (actualURL.equals("/pages/data")) {

			if (validSession(request, response)) {
				String id = request.getParameter("id");

				if (id.equals("view")) {
					viewUserReimbursements(request, response);
				}

				else if (id.equals("view-all")) {
					viewAllReimbursements(request, response);
				}

				else if (id.equals("view-users")) {
					viewAllUsers(request, response);
				}

				else if (id.equals("view-pending")) {
					viewPendingReimbursements(request, response);
				}
			}
		}

	}

	private void viewAllReimbursements(HttpServletRequest request, HttpServletResponse response) {

		try {
			log.debug("request to view all reimbursements");
			List<Reimbursement> list = ms.getAllReimbursements();

			// convert arraylist to json
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(list);

			// write json to the body of the response
			PrintWriter writer = response.getWriter();
			writer.write(json);

			log.debug("wrote to body of response");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void viewUserReimbursements(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {
			log.debug("request to view all user reimbursements");
			User user = (User) request.getSession().getAttribute("user");
			List<Reimbursement> list = us.getReimbursementsByUser(user);

			// convert arraylist to json
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(list);

			// write json to the body of the response
			PrintWriter writer = response.getWriter();
			writer.write(json);

			log.debug("wrote to body of response");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void viewPendingReimbursements(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {
			log.debug("request to display all user reimbursements");

			List<Reimbursement> list = us.getReimbursementsByStatusId(1);

			// convert arraylist to json
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(list);

			// write json to the body of the response
			PrintWriter writer = response.getWriter();
			writer.write(json);

			log.debug("wrote to body of response");

			return;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void viewAllUsers(HttpServletRequest request, HttpServletResponse response) {

		try {
			log.debug("request to display all users");

			List<User> list = us.getAllUsers();

			// convert arraylist to json
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(list);

			// write json to the body of the response
			PrintWriter writer = response.getWriter();
			writer.write(json);

			log.debug("wrote to body of response");
			return;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private boolean validSession(HttpServletRequest request, HttpServletResponse response) {

		boolean valid = true;

		try {
			User user = (User) request.getSession().getAttribute("user");

			if (user == null) {
				valid = false;
				log.debug("User has no access to this page!");
				log.debug("Redirecting to home...");
				response.sendRedirect("/ERS");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return valid;
	}

}
