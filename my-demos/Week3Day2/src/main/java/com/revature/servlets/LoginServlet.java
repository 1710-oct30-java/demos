package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.beans.User;

public class LoginServlet extends DefaultServlet {
	private Logger log = Logger.getRootLogger();

	@Override
	public void init() throws ServletException {
		log.debug("started up servlet");
		ServletConfig conf = getServletConfig();
		System.out.println(" config is unique to each servlet, someVar has the value of:");
		System.out.println(conf.getInitParameter("someVar"));

		ServletContext context = getServletContext();
		System.out.println("context is shared between all servlets, regardless of the current session, shared has the value of:");
		System.out.println(context.getInitParameter("shared"));

		super.init();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// read user from the body of the request
		User u = new User();
		BufferedReader lines = request.getReader();
		u.setUsername(lines.readLine());
		u.setPassword(lines.readLine());

		// store user in the session to view sessions
		HttpSession sess = request.getSession();
		sess.setAttribute("user", u);

		
		// store user in context
		ServletContext context = getServletContext();
		context.setAttribute("user", u);
		System.out.println("logged in");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// read the user from the session
		User u = (User) request.getSession().getAttribute("user");
		System.out.println("user from session");
		System.out.println(u);
		
		// read the user from the context
		ServletContext context = getServletContext();
		System.out.println("user from context");
		System.out.println(context.getAttribute("user"));
		
		
		// view session id
		System.out.println("session id=" + request.getSession().getId());
	}
}
