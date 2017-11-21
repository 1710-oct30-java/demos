package com.ers.beans;

public class UserRoles {
	private int role_id;
	private String user_role;
	
	public UserRoles() {
		super();
	}

	public UserRoles(int role_id, String user_role) {
		this.role_id = role_id;
		this.user_role = user_role;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	@Override
	public String toString() {
		return "Role ID:\t" + role_id + "\nUser Role:\t" + user_role + "\n";
	}
	
	
}
