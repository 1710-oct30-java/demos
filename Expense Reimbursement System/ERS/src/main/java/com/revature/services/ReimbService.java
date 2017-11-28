package com.revature.services;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.daos.ReimbDao;
import com.revature.daos.ReimbDaoJdbc;

public class ReimbService
{
	private ReimbDao rd = new ReimbDaoJdbc();
	
	public List<Reimbursement> getAll()
	{
		// have checks to see if the user requesting this is an admin
		return rd.findAll();
	}
	
	public void save(Reimbursement r)
	{
		rd.save(r);
	}
}