package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.RestaurantDao;
import com.revature.dao.ReviewDao;
import com.revature.entities.Restaurant;
import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.entities.UserReviewRest;

@Service
public class RestaurantService {

	@Autowired
	RestaurantDao rd;// = new RestaurantDaoHibernate();
	@Autowired
	ReviewDao reviewDao;// = new ReviewDaoHibernate();

	public Restaurant getRestaurantById(int i) {
		return rd.getRestaurantById(i);
	}

	public Review addReview(User user, Restaurant restaurant, Review review) {
		System.out.println(
				"user: " + user.toString() + "restaurant: " + restaurant.toString() + "review: " + review.toString());
		return reviewDao.addReview(user, restaurant, review);
	}

	public List<Restaurant> getAll() {
		// TODO Auto-generated method stub
		return rd.getAllRestaurants();
	}

	public Set<Review> getRestaurantsReviewsByRestaurantId(int restId) {
		return rd.getRestaurantById(restId).getReviews();
	}

	public List<UserReviewRest> constructUserRevRest(int restId, String restName, List<Review> restReviews, List<User> allUser) {

		List<UserReviewRest> userRevRest = new ArrayList<UserReviewRest>();

		for (Review rev : restReviews) {
			for (User user : allUser) {
				for (Review userRev : user.getReviews()) {
					if (userRev.getReview_id() == rev.getReview_id()) {
						UserReviewRest temp = new UserReviewRest();
						temp.setComment(userRev.getComment());
						temp.setRating(userRev.getRating());
						temp.setRestaruantId(restId);
						temp.setRestName(restName);
						temp.setReview_id(userRev.getReview_id());
						temp.setUserId(user.getUserId());
						temp.setUsername(user.getUsername());
						userRevRest.add(temp);
					}
				}
			}
		}

		return userRevRest;
	}

}
