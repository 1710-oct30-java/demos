package com.beans;

public class User
{
	private int userId;
	private String username;
	private String password;
	private String fName;
	private String lName;
	private String email;
	private int roleId;
	private String roleName;
	private byte[] salt;

	public User(int userId, String username, String password, String fName, String lName, String email, int roleId)
	{
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.roleId = roleId;
	}

	public User()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUsername()
	{
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

	public String getfName()
	{
		return fName;
	}

	public void setfName(String fName)
	{
		this.fName = fName;
	}

	public String getlName()
	{
		return lName;
	}

	public void setlName(String lName)
	{
		this.lName = lName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getRoleId()
	{
		return roleId;
	}

	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	public byte[] getSalt()
	{
		return salt;
	}

	public void setSalt(byte[] salt)
	{
		this.salt = salt;
	}

	@Override
	public String toString()
	{
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", fName=" + fName
				+ ", lName=" + lName + ", email=" + email + ", roleId=" + roleId + "]";
	}

}
