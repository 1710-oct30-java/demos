package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDao {
	List<User> getAllUsers();
	User getUserById(int id);
}
