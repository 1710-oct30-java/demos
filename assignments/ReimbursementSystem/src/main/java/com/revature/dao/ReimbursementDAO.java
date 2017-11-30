package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;

public interface ReimbursementDAO {
	
	/*
	 * Method to create a reimbursement
	 * @param reimbursement
	 * @return
	 */
	void addReimbursement(Reimbursement reimb);
	
	/*
	 * Method to update a reimbursement
	 * @param reimbursement
	 * @return
	 */
	void updateReimbursement(int reimId, int status, int resolverId);
	
	
	/*
	 * Method to view all of the reimbursements
	 */
	List<Reimbursement> viewAllReimbursements();
	
	/*
	 * Method to view the reimbursements of a user
	 */
	List<Reimbursement> reimbursementsByUserId(int id);

	List<Reimbursement> approveOrDeny(int id);
}
