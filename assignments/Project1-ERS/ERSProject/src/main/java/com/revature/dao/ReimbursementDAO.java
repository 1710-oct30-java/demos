package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	
	Reimbursement getReimbursementByID(int id);
	
	List<Reimbursement> retrieveAllReimbursements();
	
	int addReimbursement(Reimbursement rb);
	
	void approveDeny(String choice);
}