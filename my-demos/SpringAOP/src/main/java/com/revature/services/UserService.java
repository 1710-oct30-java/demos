package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo ur;

	public String testMethod() {
		try {
			ur.repoMethod3("hello", 2);
		} catch (Exception e) {
		}
		return "";
	}

	public void testMethod2() {
		ur.repoMethod1();
		ur.repoMethod2();
	}
}
