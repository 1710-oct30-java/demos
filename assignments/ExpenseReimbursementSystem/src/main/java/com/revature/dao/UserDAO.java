package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {

	List<User> findAll();

	User findByUsernameAndPassword(String username, String password);

}
