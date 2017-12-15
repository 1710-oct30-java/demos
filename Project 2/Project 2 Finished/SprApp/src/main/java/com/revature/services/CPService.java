package com.revature.services;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.entities.Restaurant;
import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.entities.UserReviewRest;
import com.revature.utilities.Password;

@Service
public class CPService {
	@Autowired
	Password pHash;
	@Autowired
	UserDao ud;// = new UserDaoHibernate();

	public User changePass(User u) {
		String tempPass = u.getPassword();
		System.out.println(u);
		try {
			byte[] salt = pHash.getSalt();
			String hashedPass = pHash.getSecurePassword(tempPass, salt);
			u.setPassword(hashedPass);
			u.setSalt(salt);

			ud.updateUser(u);
			return u;

		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public User changeInfo(User u) {
		User temp = ud.getUserById(u.getUserId());
		temp.setFirstName(u.getFirstName());
		temp.setLastName(u.getLastName());
		temp.setEmail(u.getEmail());
		temp.setPassword(ud.findByUsername(u.getUsername()).getPassword());
		temp.setSalt(u.getSalt());
		System.out.println(u);
		try {

			ud.updateUser(u);
			return u;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<UserReviewRest> constructUserRevRest(int userId, String username, List<Review> userReviews,
			List<Restaurant> allRest) {

		List<UserReviewRest> userRevRest = new ArrayList<UserReviewRest>();

		for (Review rev : userReviews) {
			for (Restaurant rest : allRest) {
				for (Review restRev : rest.getReviews()) {
					if (restRev.getReview_id() == rev.getReview_id()) {
						UserReviewRest temp = new UserReviewRest();
						temp.setComment(restRev.getComment());
						temp.setRating(restRev.getRating());
						temp.setRestaruantId(rest.getRestaruantId());
						temp.setRestName(rest.getName());
						temp.setReview_id(restRev.getReview_id());
						temp.setUserId(userId);
						temp.setUsername(username);
						userRevRest.add(temp);
					}
				}
			}
		}

		return userRevRest;
	}



}
