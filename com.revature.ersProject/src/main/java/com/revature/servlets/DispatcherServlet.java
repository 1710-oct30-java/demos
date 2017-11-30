package com.revature.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;
import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;

public class DispatcherServlet extends DefaultServlet {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getRootLogger();
	private UserController uc = new UserController();
	private LoginController lc = new LoginController();
	private ReimbursementController rc = new ReimbursementController();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if (actualURL.startsWith("/static")) {
            super.doGet(request, response);
            return;
        }
		
		else if (actualURL.startsWith("/reimbursements")) {
			rc.delegateGet(request, response);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);
		
		if(actualURL.startsWith("/home/login")) {
			log.debug("attempting login");
			lc.delegatePost(request, response);
		}
		
		else if(actualURL.startsWith("/reimbursements")) {
			rc.delegatePost(request, response);
		}
		
		
	}
}
