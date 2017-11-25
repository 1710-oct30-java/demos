package com.revature.services;

import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoJDBC;
import com.revature.exceptions.InvalidCredentialException;
import com.revature.util.ConnectionUtil;

public class UserService {
	private UserDao ud = new UserDaoJDBC();

	public List<User> getAllUsers() {
		// have checks to see if the user requesting this is an admin
		return ud.findAll();
	}
	
	public void login() throws InvalidCredentialException {
		throw new InvalidCredentialException(403);
	}

}
