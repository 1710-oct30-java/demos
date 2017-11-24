package com.services;

import java.util.List;

import com.beans.Reimb;
import com.dao.ReimbDao;
import com.dao.ReimbDaoJDBC;

public class ReimbService
{
	private ReimbDao rd = new ReimbDaoJDBC();

	public List<Reimb> getAllReimb()
	{
		// have checks to see if the user requesting this is an admin
		return rd.findAll();
	}
}
