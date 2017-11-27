package com.services;

import org.apache.log4j.Logger;

import com.beans.User;
import com.dao.UserDao;
import com.dao.UserDaoJDBC;

public class LoginService
{
	Logger log = Logger.getRootLogger();

	private UserDao ud = new UserDaoJDBC();

	public User checkUser(User cred)
	{
		try
		{
			User u = ud.getUser(cred.getUsername());
			if (u == null)
			{
				return null;
			}
			else if (u.getPassword().equals(cred.getPassword()))
			{
				return u;
			}
			else
			{
				return null;
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			log.debug("Cannot Find a User With Username: " + cred.getUsername());
			// e.printStackTrace();
			return null;
		}
	}

}
