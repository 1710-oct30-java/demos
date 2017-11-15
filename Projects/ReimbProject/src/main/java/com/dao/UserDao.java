package com.dao;

import java.util.List;

import com.beans.User;

public interface UserDao
{
	/**
	 * return all users
	 * @return
	 */
	List<User> findAll();
}
