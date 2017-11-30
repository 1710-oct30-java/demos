package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;

public interface UsersDAO {
	
	/*
	 * Method to create a user
	 */
	int addUser(User u);
		
	/*
	 * Method to see the users list of reimbursements
	 */
	List<User> findAllUsers();
	
	/*
	 * Method to find a user by id
	 */
	User findUserById(int id);
	
	/*
	 * Method to find the user by username and password
	 */
	User findByUsernameAndPassword(String username, String password);
}
