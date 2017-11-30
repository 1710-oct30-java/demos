package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.controllers.HomeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;

public class FrontController extends DefaultServlet {
	Logger log = Logger.getRootLogger();
	private LoginController lc = new LoginController();
	private ReimbursementController rc = new ReimbursementController();
	private HomeController hc = new HomeController();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get request made with url " + request.getRequestURI());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());

		switch (actualURL) {
		case "/":
			lc.delegateGet(request, response);
			break;
		case "/home":
			hc.delegateGet(request, response);
			break;
		case "/history":
			rc.delegateGet(request, response);
			break;
		case "/manageReimbursements":
			rc.delegateGet(request, response);
			break;
		case "/approve":
			rc.delegateGet(request, response);
			break;
		case "/deny":
			rc.delegateGet(request, response);
			break;
		default:
			super.doGet(request, response);
			return;
		}
	}
	// @Override
	// protected void service(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	//
	// response.setHeader("Access-Control-Allow-Origin", "https://localhost:4200");
	// response.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS,
	// DELETE");
	// }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request made with url " + request.getRequestURI());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());

		switch (actualURL) {
		case "/":
			lc.delegatePost(request, response);
			break;
		case "/new":
			rc.delegatePost(request, response);
			break;
		case "/home":
			hc.delegatePost(request, response);
			break;
		case "/history":
			rc.delegatePost(request, response);
			break;
		case "/manageReimbursements":
			rc.delegatePost(request, response);
			break;
		case "/approve":
			rc.delegatePost(request, response);
			break;
		case "/deny":
			rc.delegatePost(request, response);
			break;
		default:
			break;
		}

	}
}
