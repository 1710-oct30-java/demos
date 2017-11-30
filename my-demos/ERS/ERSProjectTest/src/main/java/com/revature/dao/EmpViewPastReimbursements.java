package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.ErsReimbursement;

public interface EmpViewPastReimbursements {
	
	public ArrayList<ErsReimbursement> empViewPastReimbursements(int ersUserId);
}
