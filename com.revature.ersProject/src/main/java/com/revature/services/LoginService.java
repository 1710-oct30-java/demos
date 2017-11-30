package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.daos.UsersDao;
import com.revature.daos.UsersDaoJdbc;

public class LoginService
{
	Logger log = Logger.getRootLogger();
	private UsersDao userd = new UsersDaoJdbc();
	
	public User signIn(String username, String password) {
		return userd.signIn(username, password);
	}
}
//	public boolean validation(String username, String password)
//	{
//		try
//		{
	//		if (userd.getPassword(username).equals(password))
	//		{
	//			log.debug("Login Success");
//				return true;
//			}
	//		log.debug("Login Failed");
	//		return false;
//		}
	//	catch (IndexOutOfBoundsException e)
//		{
	//		log.debug("Unable to Find a User With that Username: " + username);
//			// e.printStackTrace();
	//		return false;
//		}
//	}

