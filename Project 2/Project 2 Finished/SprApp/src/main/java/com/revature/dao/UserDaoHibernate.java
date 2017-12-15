package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.entities.Restaurant;
import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.utilities.SessionUtil;

@Repository
public class UserDaoHibernate implements UserDao {
	private static SessionUtil su = SessionUtil.getSessionUtil();

	public List<User> getAllUsers() {
		Session se = su.getSession();
		se.beginTransaction();
		Query query = se.createQuery("From User");
		List<User> users = query.list();
		se.getTransaction().commit();
		se.close();
		return users;
	}

	public User getUserById(int id) {
		Session se = su.getSession();
		se.beginTransaction();
		Query q = se.createQuery("From User Where userId = :id");
		q.setParameter("id", id);
		User u = (User) q.uniqueResult();
		se.getTransaction().commit();
		se.close();
		return u;
	}

	public User addUser(User u) {
		System.out.println(u);
		Session se = su.getSession();
		se.beginTransaction();
		se.save(u);
		se.getTransaction().commit();
		se.close();
		return u;
	}

	public User addUserReview(User user, Restaurant restaurant, Review review) {
		Session se = su.getSession();
		se.beginTransaction();
		user.getReviews().add(review);
		restaurant.getReviews().add(review);
		se.update(user);
		se.update(restaurant);
		se.getTransaction().commit();
		se.close();
		return user;
	}
	
	public void updateUser(User user) {
		Session se = su.getSession();
		se.beginTransaction();
		se.update(user);
		se.getTransaction().commit();
		se.close();
//		return user;
	}

	public User findByUsername(String username) {
		Session se = su.getSession();
		se.beginTransaction();
		Query query = se.createQuery("From User where username=:username");
		query.setParameter("username", username);
		try {
			User u = (User) query.list().get(0);
			se.getTransaction().commit();
			se.close();
			return u;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

}
