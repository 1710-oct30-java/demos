package com.ers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.ers.beans.Reimbursement;
import com.ers.beans.User;
import com.ers.dao.ReimbursementDAOJdbc;
import com.ers.services.ManagerService;
import com.ers.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class LoginServlet extends DefaultServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8316174831032375237L;
	
	private Logger log = Logger.getRootLogger();
	private UserService us = new UserService();
	private ManagerService ms = new ManagerService();
	

	

	
/*	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);
		if(actualURL.equals("/pages/signin.html")) {
			//super.doGet(request, response);
			try {
                // get all of the users from the service
                //List<Reimbursement> list = manager.getPendingRequests();
				
				int status_id = 0;
				try {
					status_id = Integer.parseInt(request.getParameter("id"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				List<Reimbursement> list = ms.getReimbursementsByStatusID(status_id);
                
                // convert arraylist to json
                ObjectMapper om = new ObjectMapper();
                ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
                String json = ow.writeValueAsString(list);
                
                // write json to the body of the response
                PrintWriter writer = response.getWriter();
                writer.write(json);
                
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
			//return;
		}		
	}
	*/
}
