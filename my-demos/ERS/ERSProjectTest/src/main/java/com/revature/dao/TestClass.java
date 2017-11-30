package com.revature.dao;

import java.time.LocalDateTime;

import com.revature.beans.ErsReimbursement;

public class TestClass {
	static LocalDateTime now = LocalDateTime.now();
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
//		ErsReimbursement reimbursement = new ErsReimbursement(2, 35.50F, now, 1, 1, 1); //this will be created using the session
//		
//		AddReimbursementJDBC reimbursementJDBC = new AddReimbursementJDBC();
//		reimbursementJDBC.submitReimbReq(reimbursement);
		
		EmpViewPastReimbursmentsJDBC viewPast = new EmpViewPastReimbursmentsJDBC();
		System.out.println(viewPast.empViewPastReimbursements(2));
		
//		ManagerViewJDBC mv = new ManagerViewJDBC();
//		System.out.println(mv.getAllRequests());
//		System.out.println(mv.getRequestsByStatusId(1));
	}
}
