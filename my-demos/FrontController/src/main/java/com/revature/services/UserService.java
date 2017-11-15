package com.revature.services;

import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoJDBC;

public class UserService {
	private UserDao ud = new UserDaoJDBC();

	public List<User> getAllUsers() {
		// have checks to see if the user requesting this is an admin
		
		return ud.findAll();
	}

}
