package com.revature.services;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.daos.ReimbursementDaoJdbc;
import com.revature.daos.UsersDao;
import com.revature.daos.UsersDaoJdbc;
public class ServiceUser {
	
private UsersDao ud = new UsersDaoJdbc();
	
ReimbursementDaoJdbc dao = new ReimbursementDaoJdbc();
	public User login( User u) {
		return ud.signIn(u.getUsername(), u.getPassword());
		
	}

	public List<Reimbursement> getReimbursementsByStatusId(int id) {
		return dao.getReimbursementsByStatusID(id);
	}	
	/*
	public List<Reimbursement> getReimbursementsByUser(User user) {
		return dao.getReimbursementsByUser();
	}
	*/

	public void displayReimbursements(List<Reimbursement> list) {
		for(Reimbursement reimb:list) {
			System.out.println(reimb);
		}
	}
}