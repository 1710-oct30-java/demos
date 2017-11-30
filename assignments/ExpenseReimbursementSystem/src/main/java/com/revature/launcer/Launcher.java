package com.revature.launcer;

import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOJDBC;

public class Launcher {

	/*
	 * Does not use launcher
	 * 
	 * Leaving it in for now
	 * 
	 */

	private static UserDAO udao = new UserDAOJDBC();

	public static void main(String[] args) {
		List<User> users = udao.findAll();
		System.out.println(users);

	}

}
