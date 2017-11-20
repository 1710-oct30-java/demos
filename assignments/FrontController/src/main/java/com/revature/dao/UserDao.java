package com.revature.dao;

public interface UserDao {
	
	public void findByUsernameAndPassword(String username, String password);
	
	public void findByUserId(int userid);
}
