package com.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.services.ReimbService;

public class DispatchServlet extends DefaultServlet
{
	ReimbService rs = new ReimbService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());

		if (actualURL.startsWith("/static"))
		{
			super.doGet(request, response);
			return;
		}
		else if ("/".equals(actualURL))
		{
			// forward, the clients url will not change
			request.getRequestDispatcher("/static/index.html").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		// super.doPost(request, response);
		ObjectMapper om = new ObjectMapper();
		ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(rs.getAllReimb());
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}
}
