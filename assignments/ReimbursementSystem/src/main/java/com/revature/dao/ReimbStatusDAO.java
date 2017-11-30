package com.revature.dao;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;

public interface ReimbStatusDAO {
	/*
	 * Method to change the status of the reimbursement
	 */
	ReimbursementStatus updateStatus(ReimbursementStatus r);
	
	
}
