package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repos.UserDao;

@Service("user service")
public class UserService {

	@Autowired
	// can use @Qualifier if you need to specify a specific bean to be injected here
	private UserDao ud;

	public boolean login(String username, String password) {
		System.out.println("called user service login");
		ud.findByUsernameAndPassword(username, password);
		return false;
	}
}
