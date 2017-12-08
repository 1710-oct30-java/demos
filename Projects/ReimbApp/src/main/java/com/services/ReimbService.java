package com.services;

import java.io.IOException;
import java.util.List;

import com.beans.Reimb;
import com.beans.User;
import com.dao.ReimbDao;
import com.dao.ReimbDaoJDBC;
import com.dao.RoleDao;
import com.dao.RoleDaoJDBC;
import com.dao.StatusDao;
import com.dao.StatusDaoJDBC;
import com.dao.TypeDao;
import com.dao.TypeDaoJDBC;
import com.dao.UserDao;
import com.dao.UserDaoJDBC;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ReimbService
{
	private ReimbDao rd = new ReimbDaoJDBC();
	private TypeDao td = new TypeDaoJDBC();
	private StatusDao sd = new StatusDaoJDBC();
	private RoleDao rld = new RoleDaoJDBC();
	private UserDao ud = new UserDaoJDBC();

	public String getAllReimb() throws IOException
	{
		// have checks to see if the user requesting this is an admin
		List<Reimb> reimbTable = rd.findAll();

		reimbTable = popType(reimbTable);
		reimbTable = popStatus(reimbTable);
		reimbTable = popAuthor(reimbTable);
		reimbTable = popResolver(reimbTable);

		ObjectMapper om = new ObjectMapper();
		ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(reimbTable);
		return json;

	}

	public String getUserReimb(User cred) throws IOException
	{
		List<Reimb> reimbTable = rd.getReimb(cred);

		reimbTable = popType(reimbTable);
		reimbTable = popStatus(reimbTable);
		reimbTable = popAuthor(reimbTable);
		reimbTable = popResolver(reimbTable);

		ObjectMapper om = new ObjectMapper();
		ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(reimbTable);
		return json;
	}

	public void newReimb(Reimb reimb, int resolver)
	{
		if (rd.reimbExistsChanged(reimb))
		{

			rd.updateReimb(reimb, resolver);
		}
		else
		{
			rd.insertNewReimb(reimb);
		}
	}

	public List<Reimb> popType(List<Reimb> temp)
	{
		for (Reimb single : temp)
		{
			single.setTypeName(td.getType(single.getType()));
		}
		return temp;
	}

	public List<Reimb> popStatus(List<Reimb> temp)
	{
		for (Reimb single : temp)
		{
			single.setStatusName(sd.getStatus(single.getStatusId()));
		}
		return temp;
	}

	public List<Reimb> popAuthor(List<Reimb> temp)
	{
		for (Reimb single : temp)
		{
			single.setAuthorName(ud.getName(single.getAuthor()));
		}
		return temp;
	}

	public List<Reimb> popResolver(List<Reimb> temp)
	{
		for (Reimb single : temp)
		{
			single.setResolverName(ud.getName(single.getResolver()));

		}
		return temp;
	}

	public String getReimbOnStatus(int num) throws IOException
	{
		List<Reimb> reimbTable = rd.findOnStatus(num);

		reimbTable = popType(reimbTable);
		reimbTable = popStatus(reimbTable);
		reimbTable = popAuthor(reimbTable);
		reimbTable = popResolver(reimbTable);

		ObjectMapper om = new ObjectMapper();
		ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(reimbTable);
		return json;
	}

}
