package com.revature.daos;

import com.revature.beans.User;

public interface UserDAO {
	
	/**
	 * @param username
	 * @return Returns a User based on the given Username.
	 */
	public User getUserByUsername(String username);
	
	/**
	 * @param username
	 * @return Returns a User based on the given User ID.
	 */
	public User getUserById(int id);
	
	/**
	 * @param username
	 * @return Creates a new user based on given information.
	 */
	public int createUser(String username, String password, String firstName, String lastName, int roleID, int statusID);
	
	/**
	 * @param username
	 * @param password
	 * @return Whether a given username or email already exists within the User table.
	 */
	public boolean userExists(String username, String email);
	
	/**
	 * @param username
	 * @return String of the hashed password from the database. Returns empty string if it fails.
	 */
	public String getPasswordByUsername(String username);
}
