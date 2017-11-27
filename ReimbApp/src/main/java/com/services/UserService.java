package com.services;

import java.util.List;

import com.beans.User;
import com.dao.RoleDao;
import com.dao.RoleDaoJDBC;
import com.dao.UserDao;
import com.dao.UserDaoJDBC;

public class UserService
{
	private UserDao ud = new UserDaoJDBC();
	private RoleDao rd = new RoleDaoJDBC();

	public List<User> getAllUsers()
	{
		// have checks to see if the user requesting this is an admin
		return ud.findAll();
	}

	public User popRole(User u)
	{
		u.setRoleName(rd.getRole(u.getRoleId()));
		return u;
	}
}
