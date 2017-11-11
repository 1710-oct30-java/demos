package com.ers.dao;

public class UsersDAO {
	private int user_id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int role_id;

	public UsersDAO() {
		super();
	}

	public UsersDAO(int user_id, String username, String password, String firstName, String lastName, String email, int role_id) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role_id = role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "User ID:\t" + user_id
				+ "\nUsername:\t" + username
				+ "\nFirst Name:\t" + firstName
				+ "\nLast Name:\t" + lastName
				+ "\nEmail:\t\t" + email
				+ "\nRole ID:\t" + role_id;
	}

}
