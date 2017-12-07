package com.revature.repositories;

import java.util.List;

import com.revature.entities.Credential;
import com.revature.entities.User;

public interface UserRepo {

	User findByCredential(Credential cred);

	User save(User u);

	List<User> findAll();

	User saveNested(User u) throws Exception;
}
