package com.revature.beans;

public class LoginCredentials {
	private String username;
	private String password;

	public LoginCredentials() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "LoginCredentials [username=" + username + ", password=" + password + "]";
	}

}
