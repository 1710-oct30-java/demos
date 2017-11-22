package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {

	User getUserbyId(int id);
	
	List<User> retrieveAllUsers();
	
	int addUser(User u);

	User findByUsernameAndPassword(String username, String password);
}
