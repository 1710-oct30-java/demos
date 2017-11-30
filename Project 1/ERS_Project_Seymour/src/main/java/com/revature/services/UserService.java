package com.revature.services;

import java.util.List;

import com.revature.model.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.utilities.ConnectionUtil;

public class UserService {
	private UserDAO ud = new UserDAOImpl();

	public List<User> getAllUsers() {
		return ud.getAllUsers();
	}

	public User login(User u) {
		return ud.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}

}