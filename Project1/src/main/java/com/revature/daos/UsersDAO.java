package com.revature.daos;

import java.util.List;

import com.revature.beans.Users; 

public interface UsersDAO {
		
		/**
		 * Method to find all users in the database
		 * @return List<Users>
		 */
		List<Users> findAll();
		
		/**
		 * Method to find a single user by their ID
		 * @param id
		 * @return Users
		 */
		Users findById(int id);
		
		/**
		 * Method for a user to sign in
		 * @param username, password
		 * @return boolean
		 */
		Users signIn(String username, String password);
}
