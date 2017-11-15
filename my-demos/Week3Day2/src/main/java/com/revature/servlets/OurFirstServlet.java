package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class OurFirstServlet extends DefaultServlet {
	
	@Override
	public void init() throws ServletException {
		ServletConfig conf = getServletConfig();
		System.out.println(" config is unique to each servlet, someVar has the value of:");
		System.out.println(conf.getInitParameter("someVar"));

		ServletContext context = getServletContext();
		System.out.println("context is shared between all servlets, regardless of the current session, shared has the value of:");
		System.out.println(context.getInitParameter("shared"));

		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service");
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
		System.out.println("OUR FIRST POST");
		request.getReader().lines().forEach( line ->  {
			System.out.println(line);
		});
	}
}
