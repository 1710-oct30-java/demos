package com.revature.dao;

import com.revature.beans.User;

public interface UserDao {

	User findUser(String username, String password);
}
