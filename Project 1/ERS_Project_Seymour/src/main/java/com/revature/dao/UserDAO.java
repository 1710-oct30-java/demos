package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.User;

public interface UserDAO {
	public List<User> getAllUsers();

	public User findByUsernameAndPassword(String username, String password);
}
