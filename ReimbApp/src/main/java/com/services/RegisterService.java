package com.services;

import org.apache.log4j.Logger;

import com.beans.User;
import com.dao.UserDao;
import com.dao.UserDaoJDBC;

public class RegisterService
{
	Logger log = Logger.getRootLogger();

	private UserDao ud = new UserDaoJDBC();

	public boolean usernameAvail(User cred)
	{
		try
		{
			User u = ud.getUser(cred.getUsername());
			if (u == null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			log.debug("Can use Username: " + cred.getUsername());
			// e.printStackTrace();
			return true;
		}
	}

	public void newUser(User u)
	{
		ud.insertUser(u);

	}

}
