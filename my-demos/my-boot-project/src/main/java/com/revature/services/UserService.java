package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Credential;
import com.revature.entities.User;
import com.revature.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo ur;

	public User login(Credential cred) {
		return ur.findByCredUsernameAndCredPassword(cred.getUsername(), cred.getPassword());
	}

	public User save(User u) {
		return ur.saveAndFlush(u);
	}

	public List<User> findAll() {
		return ur.findAll();
	}

	public List<User> usernameStartsWith(String letter) {
		return ur.findByCredUsernameStartingWith(letter);
	}

	public List<User> findByIdBetween(int one, int two) {
		return ur.findByIdBetweenOrderByCredUsername(one, two);
	}

}
