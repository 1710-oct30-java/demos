package com.revature.services;

import com.revature.beans.User;
import com.revature.beans.UserLogin;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoJDBC;

public class UserService {
	private UserDao ud = new UserDaoJDBC();
	
	public User login(UserLogin u) {
		return ud.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
}
