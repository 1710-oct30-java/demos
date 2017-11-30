package com.revature.beans;

public class User {
	private int userID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int roleID;
	
	public User() {
		super();
	}
	public User(int x, String us, String ps, String fn, String ln, String em, int y) {
		userID = x;
		username = us;
		password = ps;
		firstName = fn;
		lastName = ln;
		email = em;
		roleID = y;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	

}
