package com.revature.services;

import java.util.List;

import com.revature.beans.Users;
import com.revature.daos.UsersDAO;
import com.revature.daos.UsersDAOJdbc;

public class UserService {
	private UsersDAO ud = new UsersDAOJdbc();

	public List<Users> getAllUsers() {
		//if user_role = 1
		return ud.findAll();
	}
	
	public Users getUserById(int id) {
		return ud.findById(id);
	}
	
	public Users login(Users u) {
		return ud.signIn(u.getUsername(), u.getPassword());
	}
}

