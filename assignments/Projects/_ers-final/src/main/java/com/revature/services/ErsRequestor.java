package com.revature.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ReimbRequest;
import com.revature.beans.User;
import com.revature.daos.RequestDAO;
import com.revature.daos.jdbc.RequestJDBC;
import com.revature.exceptions.ErsForbiddenException;
import com.revature.exceptions.ErsHttpException;

public class ErsRequestor
{
	private RequestDAO daoReimb = new RequestJDBC();
	private Logger log = Logger.getRootLogger();
	
	public void handleNewReimbursement(HttpServletRequest request)
		throws ErsHttpException
	{
		User currentUser = (User)request.getSession().getAttribute("user");
		
		if(currentUser == null)
		{
			throw new ErsForbiddenException();
		}
		else
		{
			try
			{
				int userID = currentUser.getUserId();
				ObjectMapper map = new ObjectMapper();
				String json = request.getReader().lines().reduce( (acc, cur) -> acc+cur ).get();
				log.debug("JSON parsed from client: " + json);
				
				ReimbRequest reimb = map.readValue(json, ReimbRequest.class);
				reimb.setAuthor(userID);
				
				log.info("Writing reimbursement object " + reimb + " to database.");
				
				int success = daoReimb.createRequest(reimb);
				
				if(success > 0)
				{
					log.info("Reimbursement request written to database. Updating user session...");
					
					currentUser.setRequests(daoReimb.getRequestsByUserId(currentUser.getUserId()));
					request.getSession().setAttribute("user", currentUser);
					
					log.info("Session update complete. Returning to fetch controller.");
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public ReimbRequest getRequestById(int id)
	{
		return daoReimb.getRequestsByUserId(id).get(0);
	}
}
