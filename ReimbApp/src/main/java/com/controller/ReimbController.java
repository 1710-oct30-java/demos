package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.beans.User;
import com.services.ReimbService;

public class ReimbController
{
	Logger log = Logger.getRootLogger();
	ReimbService rs = new ReimbService();

	public void delegateGet(HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException
	{
		log.debug("get in reimbctrl");
		request.getRequestDispatcher("/static/reimb.html").forward(request, response);

	}

	public void delegatePost(HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		log.debug("post in reimbctrl");
		User u = (User) request.getSession().getAttribute("user");
		System.out.println(u);
		String json = rs.getUserReimb(u);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}

}
