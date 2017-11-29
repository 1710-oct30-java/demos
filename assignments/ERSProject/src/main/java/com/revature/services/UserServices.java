package com.revature.services;

import com.revature.beans.User;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoJDBC;

public class UserServices {
	private UserDao ud = new UserDaoJDBC();
	
	
	public User login(User u) {
		return ud.findByUsernameAndPassword (u.getUsername(), u.getPassword());
		
	}
	
}
