package com.revature.daos;

import java.util.List;

import com.revature.beans.User;

public interface UserDao
{
	/**
	 * Uses a Prepared Statement to create a user
	 * 
	 * @param u
	 *            the user
	 * @return the user id in the database
	 */
	int save(User u);
	
	/**
	 * Finds all users in the database
	 * 
	 * @return list of all users
	 */
	List<User> findAll();
	
	/**
	 * Finds a single user by the id
	 * 
	 * @return
	 */
	User findById(int id);
	
	/**
	 * Finds a single user by their username and password
	 * 
	 * @return the user
	 */
	User findByCredentials(String username, String password);
}
