package com.revature.services;

import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoJDBC;

public class UserService {
	private UserDao ud = new UserDaoJDBC();
	
	public List<User> findAll() {
		//Insert admin/permission checks here.
		return ud.getAllUsers();
	}
	
	public User getUserById(int id) {
		return ud.getUserById(id);
	}
}
