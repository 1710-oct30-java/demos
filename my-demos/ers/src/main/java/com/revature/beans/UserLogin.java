package com.revature.beans;

public class UserLogin {
	private String username;
	private String password;
	
	public UserLogin() {
		super();
	}
	
	public UserLogin(String un, String ps) {
		username = un;
		password = ps;
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
}
