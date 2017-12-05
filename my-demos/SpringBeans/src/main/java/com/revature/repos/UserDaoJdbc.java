package com.revature.repos;

import org.springframework.stereotype.Component;

//@Component("user dao jdbc")
public class UserDaoJdbc implements UserDao {

	@Override
	public boolean findByUsernameAndPassword(String username, String password) {
		System.out.println("trying retreive user with username " + username + " and password: " + password);
		return false;
	}

}
