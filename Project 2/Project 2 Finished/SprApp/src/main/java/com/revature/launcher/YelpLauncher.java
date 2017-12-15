/*---------------------------------------------------------------
* 
* Dao's for Restaurant reviews: 
* Still need to implement blob functionality for adding pictures
* to both the review object and restaurant photos table
* 
* 
* ---------------------------------------------------------------*/
package com.revature.launcher;

import com.revature.dao.RestaurantDao;
import com.revature.dao.RestaurantDaoHibernate;
import com.revature.dao.ReviewDao;
import com.revature.dao.ReviewDaoHibernate;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoHibernate;
import com.revature.entities.Review;
import com.revature.services.RestaurantService;
import com.revature.services.UserService;
import com.revature.utilities.SessionUtil;

public class YelpLauncher {

	private static SessionUtil su = SessionUtil.getSessionUtil();

	public static void main(String[] args) {
		UserDao ud = new UserDaoHibernate();
		ReviewDao rd = new ReviewDaoHibernate();
		RestaurantDao resd = new RestaurantDaoHibernate();
		UserService us = new UserService();
		RestaurantService rs = new RestaurantService();
		/*---------------------------------------------------------------*/
		// User DAO methods
		/*---------------------------------------------------------------*/
		// Get All Users Method
//		System.out.println("getting all users: ");
//		System.out.println(ud.getAllUsers().toString());
		
		// Get Users By Id Method
//		System.out.println(ud.getUserById(19));
		
		
		// Add a New User Method: When creating a new user the userid will be generated by the database everything else will be taken from user object
//		System.out.println("adding user: ");
//		User u = new User();
//		System.out.println(u.toString());
//		ud.addUser(u);
		
		// Find By Username
//		System.out.println(ud.findByUsername("USER1").toString());
		
		
		
		/*---------------------------------------------------------------*/
		// Review DAO methods
		/*---------------------------------------------------------------*/
		// Get All Reviews Method
//		System.out.println(rd.getAllReviews().toString());
//		System.out.println(us.getUsersReviewsByUserId(1).toString());
//		System.out.println(rs.getRestaurantsReviewsByRestaurantId(1).toString());
		
		
//		System.out.println(rs.getRestaurantsReviewsByRestaurantId(41));
		
		
		// Add a Review: This method adds to both the rest_rating and user_rating junction tables
//		rd.addReview(ud.getUserById(19), resd.getRestaurantById(41), new Review()); // checked in db: it does add a review to review table
//		System.out.println(ud.getUserById(1));
//		System.out.println(resd.getRestaurantById(1));

		
		
		/*---------------------------------------------------------------*/
		// Restaurant DAO Methods
		/*---------------------------------------------------------------*/
		// Get All Restaurants Method
//		System.out.println("getting all restaurants: ");
//		System.out.println(resd.getAllRestaurants().toString()); // takes a while
		
		// Get a Restaurant By Id Method
//		System.out.println("getting restaurant with id 1");
//		System.out.println(resd.getRestaurantById(1));
		
		// Add a Restaurant Method
//		System.out.println("Adding restaurant...");
//		Restaurant r = new Restaurant();
//		System.out.println(r.toString());
//		resd.addRestaurant(r);
		
	}
}
