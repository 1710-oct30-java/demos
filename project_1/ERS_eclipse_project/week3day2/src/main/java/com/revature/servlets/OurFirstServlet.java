package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class OurFirstServlet extends DefaultServlet {
	
	public void init() throws ServletException {
		System.out.println("Starting...");
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Our first request!!");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Our first POST!!!");
		request.getReader().lines().forEach( line -> {
			System.out.println(line);
		});
	}
}
