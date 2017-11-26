package com.revature.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	
	private int userId;
	private String userName;
	private String userPassword;
	private String firstName;
	private String lastName;
	private String email;
	private int roleID;
	private int statusID;
	private List<ReimbRequest> requests; 
	
	public User()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getUserId()
	{
		return userId;
	}
	
	@Override
	public String toString()
	{
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleID=" + roleID + ", statusID="
				+ statusID + ", requests=" + requests + "]";
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	@JsonIgnore
	public String getUserPassword()
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getRoleID()
	{
		return roleID;
	}

	public void setRoleID(int roleID)
	{
		this.roleID = roleID;
	}

	public int getStatusID()
	{
		return statusID;
	}

	public void setStatusID(int statusID)
	{
		this.statusID = statusID;
	}

	public List<ReimbRequest> getRequests()
	{
		return requests;
	}

	public void setRequests(List<ReimbRequest> requests)
	{
		this.requests = requests;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	
}
