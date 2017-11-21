package com.ers.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;

import com.ers.beans.User;

public class LoginServlet extends DefaultServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		// Read user from the body of the request
		User user = new User();
		BufferedReader lines = request.getReader();
		user.setUsername(lines.readLine());
		user.setPassword(lines.readLine());
		
		// store user in the session to view sessions
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		System.out.println("Login Successful!");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		User u = (User) request.getSession().getAttribute("user");
		System.out.println(u);
	}
	
}
