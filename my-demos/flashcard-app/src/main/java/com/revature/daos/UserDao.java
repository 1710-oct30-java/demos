package com.revature.daos;

import com.revature.beans.User;

public interface UserDao {
	User findByUsernameAndPassword(String username, String password);
}
