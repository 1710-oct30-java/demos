package com.revature.services;

import com.revature.beans.Reimbursement;
import com.revature.daos.ReimbDao;
import com.revature.daos.ReimbDaoJdbc;

public class ReimbService
{
	private ReimbDao rd = new ReimbDaoJdbc();
	
	public void save(Reimbursement r)
	{
		rd.save(r);
	}
}