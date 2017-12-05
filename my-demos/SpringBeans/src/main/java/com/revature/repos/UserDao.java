package com.revature.repos;

public interface UserDao {
	boolean findByUsernameAndPassword(String username, String password);
}
