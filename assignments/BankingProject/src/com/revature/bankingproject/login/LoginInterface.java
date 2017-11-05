package com.revature.bankingproject.login;

import java.util.List;

import com.revature.bankingproject.user.DuplicateUserException;
import com.revature.bankingproject.user.User;

public interface LoginInterface {
	User create(String name, String password, String email, List<User> users) throws DuplicateUserException;

	public User userLandingPage(List<User> users);
}
