package com.revature.services;

import java.util.ArrayList;

import com.revature.beans.ErsReimbursement;
import com.revature.beans.ErsUser;
import com.revature.dao.EmpViewPastReimbursmentsJDBC;

public class ViewPastService {
	private EmpViewPastReimbursmentsJDBC ev = new EmpViewPastReimbursmentsJDBC();

	public ArrayList<ErsReimbursement> getPastById(ErsUser u) {
		return ev.empViewPastReimbursements(u.getErsUserId());	
	}
	
}
