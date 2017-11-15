package com.revature.dao;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	Reimbursement getReimbursementByID(int id);
	
	Reimbursement getReimbursementByType(int type);
	
	String getUserbyReimbursementID(int id);
	
	
}
