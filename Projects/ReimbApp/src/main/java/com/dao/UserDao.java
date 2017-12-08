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
	 * get user object for a username
	 * 
	 * @param username
	 * @return
	 */

	User getUser(String username);

	String getName(int id);

	void insertUser(User u);
}
