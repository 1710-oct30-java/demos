package com.revature.services;

/*
 * Class: UserService
 * Author: Kyle Settles
 * Description: class used to handle all of the business logic associated with the users
 * 		Can call Login and Register functions from the database
 */

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDaoJDBC;

public class UserService {

	private UserDAO ud = new UserDaoJDBC();
	
	// logs a user into the system
	public User login(User u) {
		return ud.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	
	// registers a new user to the system
	public int register(User u) {
		return ud.addUser(u);
	}
}