package com.revature.services;


import com.revature.beans.User;
import com.revature.dao.UserDaoJDBC;
import com.revature.dao.UsersDAO;

public class UserService {
	private UsersDAO ud = new UserDaoJDBC();

	public User login(User u) {
		return ud.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}

}
