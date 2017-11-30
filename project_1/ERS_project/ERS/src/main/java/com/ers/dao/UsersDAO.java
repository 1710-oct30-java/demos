package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ers.beans.User;

public interface UsersDAO {
	
	
	/**
	 * Access database and returns user ID of user
	 * @param user
	 * @return user_id
	 */
	public int getUserId(User user);

	
	
	/**
	 * Access database and returns a user with the updated information from the
	 * database.
	 * 
	 * @param user
	 * @return User
	 */
	public User getUserInformation(User user);

	
	
	/**
	 * Returns true if user exists in the database.
	 * Checks user based on username.
	 * @param user
	 * @return boolean
	 */
	public boolean userExists(User user);

	
	
	/**
	 * Add user to the database
	 * 
	 * @param User
	 */
	public void addUser(User user);

	
	
	/**
	 * Deletes a user from the Database.
	 * @param user
	 */
	public void deleteUser(User user);
	
	
	/**
	 * Returns true if credentials are valid.
	 * Hashes password to check for validation.
	 * @param username
	 * @param password
	 * @return true if user credentials are valid
	 */
	public boolean checkCredentials(User user);
	
	
	/**
	 * Returns a User object if username exists, else returns an empty 
	 * user with irrelevant data.
	 * @param username
	 * @param password
	 * @return User object based on username
	 */
	public User getUserFromCredentials(String username);

	
	/**
	 * Returns a list of all users in the database. List does not include user passwords.
	 * @return List
	 */
	public List<User> getAllUsers();
}
