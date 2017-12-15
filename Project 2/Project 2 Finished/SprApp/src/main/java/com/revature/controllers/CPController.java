package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Restaurant;
import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.entities.UserReviewRest;
import com.revature.services.CPService;
import com.revature.services.RestaurantService;
import com.revature.services.UserService;

@RestController
@RequestMapping("cpanel")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class CPController {

	@Autowired
	CPService cps; // = new CPService();
	@Autowired
	UserService us; // = new UserService();
	@Autowired
	RestaurantService rs;

	@PostMapping("update/pass")
	public ResponseEntity<?> updateUserPass(@RequestBody User u) {
		System.out.println("updadting");
		return new ResponseEntity<>(cps.changePass(u), HttpStatus.OK);
	}
	@PostMapping("update/info")
	public ResponseEntity<?> updateUserInfo(@RequestBody User u) {
		System.out.println("updadting");
		return new ResponseEntity<>(cps.changeInfo(u), HttpStatus.OK);
	}

	@PostMapping("allUserReviews/{id}")
	public ResponseEntity<?> getAllUserReviews(@PathVariable int id, @RequestBody String username) {
		System.out.println("getting reviews for "+ username+" "+id);
		List<Review> userReviews = new ArrayList<>(us.getUsersReviewsByUserId(id));
		List<Restaurant> allRest = rs.getAll();
		List<UserReviewRest> uRs = cps.constructUserRevRest(id, username, userReviews, allRest);

		return new ResponseEntity<>(uRs, HttpStatus.OK);
	}

}
