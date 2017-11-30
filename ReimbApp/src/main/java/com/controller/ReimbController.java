package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.beans.Reimb;
import com.beans.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.ReimbService;

public class ReimbController
{
	Logger log = Logger.getRootLogger();
	ReimbService rs = new ReimbService();

	public void delegateGet(HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException
	{
		log.debug("get in reimbctrl");
		User u = (User) request.getSession().getAttribute("user");
		if (u == null)
		{
			response.sendRedirect("/Reimbursement/login");
		}
		else if (u.getRoleId() == 1)
		{
			request.getRequestDispatcher("/static/reimb.html").forward(request, response);
		}
		else if (u.getRoleId() == 2)
		{
			request.getRequestDispatcher("/static/reimbM.html").forward(request, response);
		}

	}

	public void delegatePost(HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException
	{
		log.debug("post in reimbctrl");

		StringBuilder jb = new StringBuilder();
		String line = null;
		BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null)
		{
			jb.append(line);
		}
		reader.close();

		if (jb.length() == 0)
		{
			returnReimbJson(request, response);
		}
		else
		{
			User u = (User) request.getSession().getAttribute("user");
			newReimb(u, jb);
			returnReimbJson(request, response);
		}
	}

	private void newReimb(User u, StringBuilder jb) throws IOException
	{
		ObjectMapper om = new ObjectMapper();
		Reimb r = om.readValue(jb.toString(), Reimb.class);
		r.setAuthor(u.getUserId());
		rs.newReimb(r, u.getUserId());

	}

	private void returnReimbJson(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		User u = (User) request.getSession().getAttribute("user");
		String json = rs.getUserReimb(u);
		PrintWriter out = response.getWriter();
		// System.out.println(json);
		out.print(json);
		out.close();

	}

}
