package com.revature.daos;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbDao
{
	/**
	 * Uses a Prepared Statement to create a reimbursement
	 * 
	 * @param r
	 * @return
	 */
	int save(Reimbursement r);
	
	/**
	 * Finds all reimbursements in the database
	 * 
	 * @return
	 */
	List<Reimbursement> findAll();
	
	/**
	 * Finds a single reimbursement by the id
	 * 
	 * @return
	 */
	Reimbursement findById(int id);
}