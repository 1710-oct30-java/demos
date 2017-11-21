package com.ers.beans;

import java.util.List;

public class Personnel {
	
	private List<User> users;
	
	/**
	 * Returns a list of users, both Employee and Manager.
	 */
	public List<User> getUsers() {
		return users;
	}
	
	/**
	 * Adds a user to the database
	 */
	public void addUser(User user) {
		users.add(user);
	};
	
	@Override
	public String toString() {
		return "Users: \n" + users;
	}
	
}
