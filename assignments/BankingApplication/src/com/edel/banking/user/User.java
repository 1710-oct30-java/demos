package com.edel.banking.user;

import java.util.ArrayList;
import java.util.List;

public class User
{
	private String firstName;
	private String lastName;
	private String name;
	private String email;
	private String username;
	private String password;
	private String userType;
	
	public static List<User> userList = new ArrayList<User>();

	public User(String firstName, String lastName, String email, String password)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		setName();
		this.email = email;
		this.password = password;
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

	public String getName()
	{
		if(name == null)
			return "no name created";
		return name;
	}

	public void setName()
	{
		this.name = getFirstName() + " " + getLastName();
	}

	public String getEmail()
	{
		if(email == null)
			return "no email created";
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getUsername()
	{
		if(username == null)
			return "no username created";
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getUserType()
	{
		return userType;
	}
	
	public void setUserType(String userType)
	{
		this.userType = userType;
	}
	
	@Override
	public String toString()
	{
		return getName() + "\n" + getEmail() + "\n" + getUsername() + "\n";
	}
}
