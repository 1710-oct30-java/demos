package com.ers.services;

import java.util.List;

import com.ers.beans.Reimbursement;
import com.ers.beans.User;
import com.ers.dao.ReimbursementDAOJdbc;
import com.ers.dao.UserRolesDAO;
import com.ers.dao.UsersDAOJdbc;

public class UserService extends UsersDAOJdbc {
	
	ReimbursementDAOJdbc dao = new ReimbursementDAOJdbc();
	
	/**
	 * Returns list of reimbursements by status ID.
	 * @param id
	 * @return
	 */
	public List<Reimbursement> getReimbursementsByStatusId(int id) {
		return dao.getReimbursementsByStatusID(id);
	}
	
	
	/**
	 * Returns list of reimbursements by status User.
	 * @param user
	 * @return
	 */
	public List<Reimbursement> getReimbursementsByUser(User user) {
		return dao.getReimbursementsByUser(user);
	}
	
	
	/**
	 * Displays list of reimbursements to console via System.out.println().
	 * @param list
	 */
	public void displayReimbursements(List<Reimbursement> list) {
		for(Reimbursement reimb:list) {
			System.out.println(reimb);
		}
	}
	
	/**
	 * Adds reimbursement to database and to user reimbursements list.
	 * @param user
	 * @param amount
	 * @param description
	 * @param r_type_id
	 */
	public void addReimbusement(User user, Reimbursement reimb) {
		dao.addReimbursement(user, reimb);
		user.getReimbursements().add(reimb);
	}
	
	
	/**
	 * Logs in user.
	 * @param username
	 */
	public void loginUser(User user, String username) {
		user = getUserFromCredentials(username);
		user.getReimbursements().addAll(getReimbursementsByUser(user));
		System.out.println(user);
		System.out.println();
		System.out.println(user.getReimbursements());
	}
	
	
	public List<User> getAllUsers() {
		return super.getAllUsers();
	}
	
}
