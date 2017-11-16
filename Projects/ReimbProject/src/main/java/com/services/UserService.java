package com.services;

import java.util.List;

import com.beans.User;
import com.dao.UserDao;
import com.dao.UserDaoJDBC;

public class UserService
{
	private UserDao ud = new UserDaoJDBC();

	public List<User> getAllUsers() {
		// have checks to see if the user requesting this is an admin
		return ud.findAll();
	}
}
