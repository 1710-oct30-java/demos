package com.revature.services;

import java.util.List;

import com.revature.model.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.utilities.ConnectionUtil;

public class UserService {
	private UserDAO ud = new UserDAOImpl();

	public List<User> getAllUsers() {
		// have checks to see if the user requesting this is an admin
		return ud.getAllUsers();
	}

	public User login(User u) {
		// TODO Auto-generated method stub
		return ud.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}

}