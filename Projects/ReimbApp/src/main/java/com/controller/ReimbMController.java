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

public class ReimbMController
{
	Logger log = Logger.getRootLogger();
	ReimbService rs = new ReimbService();

	public void delegateGet(HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException
	{
		log.debug("get in reimbMctrl");
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
			log.debug("user is manager");
			request.getRequestDispatcher("/static/reimbM.html").forward(request, response);
		}

	}

	public void delegatePost(HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException
	{
		log.debug("post in reimbMctrl");

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
			returnAllReimbJson(request, response);
		}
		else if (jb.toString().equals("mine"))
		{
			log.debug("request for my reimb");
			returnUserReimbJson(request, response);
		}
		else if (jb.toString().equals("all"))
		{
			log.debug("request for my reimb");
			returnAllReimbJson(request, response);
		}
		else
		{
			User u = (User) request.getSession().getAttribute("user");
			newReimb(request, response, u, jb);

		}
	}

	private void newReimb(HttpServletRequest request, HttpServletResponse response, User u, StringBuilder jb)
			throws IOException
	{
		ObjectMapper om = new ObjectMapper();

		Reimb r = om.readValue(jb.toString(), Reimb.class);
		String name = r.getAuthorName();
		if (name == null)
		{
			log.debug("authorname is " + name + " ,should be null");
			log.debug("request to create new reimb");
			r.setAuthor(u.getUserId());
			rs.newReimb(r, u.getUserId());
			returnAllReimbJson(request, response);
		}
		else
		{
			/*
			 * IMPLEMENTS CHECKS IF AUTHORNAME == SESSION USER LASTNAME IF EQUALS, DON'T
			 * ALLOW STATUS CHANGE AND RETURN RESPONSE IF NOT, ALLOW STATUS CHANGE AND
			 * RETURN FILE
			 */
			log.debug("authorname is " + r.getAuthorName());
			log.debug(u);
			if (name.equalsIgnoreCase(u.getlName()))
			{
				response.setStatus(401);
			}
			else
			{
				rs.newReimb(r, u.getUserId());
				returnAllReimbJson(request, response);
			}

		}

	}

	private void returnUserReimbJson(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		User u = (User) request.getSession().getAttribute("user");
		System.out.println(u);
		String json = rs.getUserReimb(u);
		PrintWriter out = response.getWriter();
		// System.out.println(json);
		out.print(json);
		out.close();

	}

	private void returnAllReimbJson(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String json = rs.getAllReimb();
		PrintWriter out = response.getWriter();
		// System.out.println(json);
		out.print(json);
		out.close();

	}

	// private void returnStatusReimbJson(HttpServletRequest request,
	// HttpServletResponse response, int num)
	// throws IOException
	// {
	// String json = rs.getReimbOnStatus(num);
	// PrintWriter out = response.getWriter();
	// // System.out.println(json);
	// out.print(json);
	// out.close();
	//
	// }

}
