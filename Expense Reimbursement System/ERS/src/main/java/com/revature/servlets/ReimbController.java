package com.revature.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.services.ReimbService;

public class ReimbController
{
	private Logger			log	= Logger.getRootLogger();
	private ReimbService	rs	= new ReimbService();
	
	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
	{
		log.debug("get request has been delegated to reimb controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/reimb".length());
		
	}
	
	public void delegatePost(HttpServletRequest request, HttpServletResponse response)
	{
		log.debug("get request delegated to reimb controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/reimb".length());
		
		if (actualURL.equals(""))
		{
			try
			{
				String json = request.getReader() // get the buffered reader
						.lines() // stream it
						.reduce((acc, cur) -> acc + cur) // reduce it to a single value
						.get(); // get that single value
				log.trace("json received = " + json);
				ObjectMapper om = new ObjectMapper();
				Reimbursement r = om.readValue(json, Reimbursement.class);
				log.trace("object created from json = " + r);
				
				rs.save(r);
			}
			catch (JsonParseException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (JsonMappingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}