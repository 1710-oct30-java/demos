package com.revature.bankingproject.tools;

import org.apache.log4j.Logger;

import com.revature.bankingproject.user.User;

public class UserTools {
	private static Logger log = Logger.getRootLogger();
	//Checks if user is admin
	public static boolean isAdmin(User user) {
		log.debug(user.getName() + " " + user.getEmail() + " " + user.getId() + " " + user.getPassword());
		return (user.getName().equals("Admin") && user.getEmail().equals(" ") && user.getId() == 0 && user.getPassword().equals(EncryptionHandler.Encrypt("123")));
	}

}
