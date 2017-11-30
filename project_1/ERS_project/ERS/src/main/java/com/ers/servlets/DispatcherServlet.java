package com.ers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.ers.beans.User;
import com.ers.controllers.LoginController;
import com.ers.controllers.ManagerController;
import com.ers.controllers.ReimbursementController;
import com.ers.controllers.UserController;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends DefaultServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3811570951465739152L;
	
	private Logger log = Logger.getRootLogger();
	private UserController uc = new UserController();
	private LoginController lc = new LoginController();
	private ReimbursementController rc = new ReimbursementController();
	private ManagerController mc = new ManagerController();

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//super.doGet(request, response);
		
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if (actualURL.equals("/") || actualURL.equals("/home")) {
			
			request.getRequestDispatcher("/index.html").forward(request, response);
			
		} else if(actualURL.equals("/pages/signin")) {
			
			lc.delegateGet(request, response);
			
		} else if(actualURL.equals("/pages/signout")) {
			
			lc.delegateLogout(request, response);
			
		} else if(actualURL.equals("/pages/data")) {
			
			uc.delegateGetData(request, response);
			
		} else if(actualURL.equals("/pages/reimbursements")) {
			
			rc.delegateGet(request, response);
			
		} else if(actualURL.equals("/pages/reimbursements/add")) {
			
			rc.delegateAdd(request, response);
			
		} else if(actualURL.equals("/pages/reimbursements/view-all")) {
			
			mc.delegateViewAll(request, response);
			
		} else if(actualURL.equals("/pages/reimbursements/approve")) {
			
			mc.delegateApprove(request, response);
			
		} else {
			
			// log.debug("URL not recognized! URL: '" + actualURL + "'");
			super.doGet(request, response);
			return;
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if(actualURL.equals("/pages/signin")) {
			lc.delegatePost(request, response);
		}
		
		else if(actualURL.equals("/pages/reimbursements/add")) {
			rc.delegatePost(request, response);
		}
		
		else if(actualURL.equals("/pages/reimbursements/approve")) {
			mc.delegatePost(request, response);
		}
	}
	
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if (actualURL.equals("/") || actualURL.equals("/index.html")) {
			//super.doGet(request, response);
			return;
		} else if (actualURL.equals("/pages/signin.html")) {
			
			//manager.getReimbursementsByStatusID(Integer.parseInt(request.getParameter("id")));
			
			
			
			// URL will change
			//response.sendRedirect(request.getContextPath() + "/index.html");
			
			// URL will not change
			request.getRequestDispatcher("/index.html").forward(request, response);
		} else {
			log.debug("URL not recognized! URL: '" + actualURL + "'");
		}
	}
	 */
}
