package com.revature.services;

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

}
