package com.revature.dao;

import java.util.List;

import com.revature.entities.Restaurant;
import com.revature.entities.Review;
import com.revature.entities.User;

public interface ReviewDao {
	List<Review> getAllReviews();
	Review addReview (User user, Restaurant restaurant, Review review);
	Review add(Review review);
}
