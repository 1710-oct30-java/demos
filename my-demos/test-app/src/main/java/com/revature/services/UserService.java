package com.revature.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Credential;
import com.revature.entities.User;
import com.revature.repositories.UserRepo;

@Service
public class UserService {
	private Logger log = Logger.getRootLogger();

	@Autowired
	private UserRepo ur;

	
	public User login(Credential cred) {
		log.trace("login method called from user service with credentials of: " + cred);
		return ur.findByCredential(cred);
	}


	public User save(User u) {
		return ur.save(u);
	}

}
