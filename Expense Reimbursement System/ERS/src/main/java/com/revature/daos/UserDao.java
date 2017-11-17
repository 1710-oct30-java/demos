package com.revature.daos;

import java.util.List;

import com.revature.beans.User;

public interface UserDao
{
	/**
	 * Uses a Prepared Statement to create a user
	 * 
	 * @param u
	 * @return
	 */
	int save(User u);
	
	/**
	 * Finds all users in the database
	 * 
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * Finds a single user by the id
	 * 
	 * @return
	 */
	User findById(int id);
}
