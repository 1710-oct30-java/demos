package com.revature.bankingproject.user;

import java.util.List;

public interface LoginInterface {
	User create(String name, String password, String email, List<User> users) throws DuplicateUserException;

	public User userLandingPage(List<User> users);
}
