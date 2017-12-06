package com.revature.repositories;

import com.revature.entities.Credential;
import com.revature.entities.User;

public interface UserRepo {
	
	User findByCredential(Credential cred);

	User save(User u);
}
