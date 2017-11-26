package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.daos.UserDAO;
import com.revature.daos.jdbc.UserJDBC;
import com.revature.util.PasswordUtil;

public class Authenticator
{
	private UserDAO daoUser = new UserJDBC();
	private Logger log = Logger.getRootLogger();
	
	public User attemptLogin(String username, String password)
	{
		log.trace("Attempting to log in user with username " + username);
		User dbUser = daoUser.getUserByUsername(username);
		
		if(dbUser.getUserPassword().equals(PasswordUtil.hashPassword(password)))
		{
			return dbUser;
		}
		else
		{
			return null;
		}
	}
	
	public User getUser(String username)
	{
		return daoUser.getUserByUsername(username);
	}
}
