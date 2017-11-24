package com.dao;

import java.util.List;

import com.beans.User;

public interface UserDao
{
	/**
	 * return all users
	 * 
	 * @return
	 */
	List<User> findAll();

	/**
	 * get password for a user
	 * 
	 * @param username
	 * @return
	 */
	List<String> getPassword(String username);
}
