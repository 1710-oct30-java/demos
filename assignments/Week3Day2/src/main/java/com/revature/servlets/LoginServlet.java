package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.beans.User;

public class LoginServlet extends DefaultServlet {
	private Logger log = root.getLogger();
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		System.out.println("OUR FIRST GET");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession sess = request.getSession();
		User u =new User();
			BufferedReader lines = request.getReader();
			u.setUsername(lines.readLine());
			u.setPassword(lines.readLine());
			sess.setAttribute("user", u);
			System.out.println("logged in");
	}
	
}
