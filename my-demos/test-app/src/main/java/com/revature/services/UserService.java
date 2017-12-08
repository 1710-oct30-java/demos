package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Credential;
import com.revature.entities.User;
import com.revature.exceptions.InvalidCredentialException;
import com.revature.repositories.UserRepo;

@Service
public class UserService {
	private Logger log = Logger.getRootLogger();

	@Autowired
	private UserRepo ur;

	@Autowired
	private SessionFactory sf;

	public User login(Credential cred) throws InvalidCredentialException {
		log.trace("login method called from user service with credentials of: " + cred);
		User u = ur.findByCredential(cred);
		if (u == null) {
			throw new InvalidCredentialException("Username or password invalid");
		} else {
			return u;
		}
	}

	public User save(User u) {
		return ur.save(u);
	}

	@Transactional
	public List<User> findAll() {
		return ur.findAll();

	}

	@Transactional
	public void saveTwo(User one, User two) {
		ur.save(one);
		try {
			ur.saveNested(two);
		} catch (Exception e) {

		}
	}

}
