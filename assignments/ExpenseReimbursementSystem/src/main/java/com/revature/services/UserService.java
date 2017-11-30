package com.revature.services;

import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOJDBC;

public class UserService {

	private UserDAO ud = new UserDAOJDBC();

	public List<User> getAllUsers() {
		// have checks to see if the user requesting this is an admin

		return ud.findAll();
	}

	public User login(User u) {
		return ud.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}

}
