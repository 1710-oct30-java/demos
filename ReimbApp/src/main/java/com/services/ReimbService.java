package com.services;

import java.io.IOException;
import java.util.List;

import com.beans.Reimb;
import com.beans.User;
import com.dao.ReimbDao;
import com.dao.ReimbDaoJDBC;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ReimbService
{
	private ReimbDao rd = new ReimbDaoJDBC();

	public List<Reimb> getAllReimb()
	{
		// have checks to see if the user requesting this is an admin
		return rd.findAll();
	}

	public String getUserReimb(User cred) throws IOException
	{
		ObjectMapper om = new ObjectMapper();
		ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(rd.getReimb(cred));
		return json;
	}
}
