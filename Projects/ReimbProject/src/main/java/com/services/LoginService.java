package com.services;

import org.apache.log4j.Logger;

import com.dao.UserDao;
import com.dao.UserDaoJDBC;

public class LoginService
{
	Logger log = Logger.getRootLogger();
	private UserDao ud = new UserDaoJDBC();

	public boolean validate(String username, String password)
	{
		try
		{
			if (ud.getPassword(username).get(0).equals(password))
			{
				log.debug("Login Success");
				return true;
			}
			log.debug("Login Failed");
			return false;
		}
		catch (IndexOutOfBoundsException e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
