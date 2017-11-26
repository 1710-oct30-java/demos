package com.revature.launcher;

import org.apache.log4j.Logger;

import com.revature.daos.UserDAO;
import com.revature.daos.jdbc.UserJDBC;

public class DAOLauncher
{
	private static UserDAO daoUser = new UserJDBC();
	//private static RequestDAO daoRequests = new RequestJDBC();
	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args)
	{
		log.debug("Starting main method.");
		
		System.out.println(daoUser.getUserByUsername("atalboy1"));
	}
}
