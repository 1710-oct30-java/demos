package com.revature.dao;

import java.util.List;

import com.revature.entities.Restaurant;
import com.revature.entities.Review;

public interface RestaurantDao {
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurantById(int id); 
	Restaurant addRestaurant(Restaurant restaurant);
	Restaurant addReview(Restaurant restaurant, Review review);
}
