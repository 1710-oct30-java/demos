package com.revature.beans;

import java.util.List;

/*
 * Java class to represent the ers_users from the database
 */
public class User {
	
	private int usersId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private UserRoles roleId;
	private List<Reimbursement> reimbList;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int usersId, String username, String password, String firstName, String lastName,
			String email, int role, List<Reimbursement> reimbList) {
		super();
		this.usersId = usersId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = new UserRoles(role);
		this.reimbList = reimbList;
	}
	
	public User(int usersId, String username, String password, String firstName, String lastName, String email,
			UserRoles roleId, List<Reimbursement> reimbList) {
		super();
		this.usersId = usersId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
		this.reimbList = reimbList;
	}


	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
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

	public UserRoles getRoleId() {
		return roleId;
	}
	
	public void setRoleId(UserRoles roleId) {
		this.roleId = roleId;
	}
	
	
	public List<Reimbursement> getReimbList() {
		return reimbList;
	}


	public void setReimbList(List<Reimbursement> reimbList) {
		this.reimbList = reimbList;
	}


	@Override
	public String toString() {
		return "User [usersId=" + usersId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleId=" + roleId + ", reimbList="
				+ reimbList + "]";
	}
	
	
	
	
}
