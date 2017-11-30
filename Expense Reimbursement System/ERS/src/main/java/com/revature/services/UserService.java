package com.revature.services;

import java.util.List;

import com.revature.beans.User;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoJdbc;

public class UserService {
	private UserDao ud = new UserDaoJdbc();

	public List<User> getAll() {
		// have checks to see if the user requesting this is an admin
		return ud.findAll();
	}

	public User login(User u) {
		return ud.findByCredentials(u.getUsername(), u.getPassword());
	}

	public void save(User u) {
		ud.save(u);
	}
}