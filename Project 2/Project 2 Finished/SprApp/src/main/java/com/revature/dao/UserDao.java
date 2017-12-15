package com.revature.dao;

import java.util.List;

import com.revature.entities.Restaurant;
import com.revature.entities.Review;
import com.revature.entities.User;

public interface UserDao {
	List<User> getAllUsers();
	User getUserById(int userId);
	User addUser(User u);
	User addUserReview (User user, Restaurant restaurant, Review review);
	User findByUsername(String Username);
	public void updateUser(User user);
}
