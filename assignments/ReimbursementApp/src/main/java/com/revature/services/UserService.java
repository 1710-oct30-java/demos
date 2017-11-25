package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoJdbc;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoJdbc;

public class UserService {
	private Logger log = Logger.getRootLogger();
	private UserDao udj = new UserDaoJdbc();

	public User login(User user) {
		User checkUser = udj.findUser(user.getUsername(), user.getPassword());
		if (user.getUsername().equals(checkUser.getUsername()) && user.getPassword().equals(checkUser.getPassword())) {
			log.trace("Login Successful");
			return checkUser;
		} else {
			log.trace("Invalid Credentials");
			return null;
		}

	}

}