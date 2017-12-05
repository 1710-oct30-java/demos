package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.repos.UserDao;

@Component("user service")
public class UserService {

	@Autowired
	private UserDao ud;

	public boolean login(String username, String password) {
		System.out.println("called user service login");
		ud.findByUsernameAndPassword(username, password);
		return false;
	}
}
