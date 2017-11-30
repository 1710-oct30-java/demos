package com.revature.front.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import com.revature.model.User;

public class DispatcherServlet extends DefaultServlet {
	private UserController uc = new UserController();
	private ReimbursementController rc = new ReimbursementController();

	private List<User> angUsers = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);
		if (actualURL.startsWith("/static")) {
			super.doGet(request, response);
			return;
		}
		if ("/home".equals(actualURL)) {
			// forward, the clients url will not change
			request.getRequestDispatcher("/static/index.html").forward(request, response);
			// redirect, the clients url will change
			// response.sendRedirect(request.getContextPath() +
			// "/static/index.html");
		}
		if (actualURL.startsWith("/users")) {
			uc.delegateGet(request, response);
		}
		if (actualURL.startsWith("/reimbursement")) {
			rc.delegateGet(request, response);
		}
		if (actualURL.equals("/angular")) {

			// convert arraylist to json
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(angUsers);

			// write json to the body of the response
			PrintWriter writer = response.getWriter();
			writer.write(json);
		}
		if (actualURL.equals("/test")) {
			System.out.println(request.getSession().getAttribute("userId"));
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);

		if (actualURL.startsWith("/users/")) {
			uc.processPost(request, response);
		}
		if (actualURL.startsWith("/reimbursement/")) {
			rc.processPost(request, response);
		}
	}
}