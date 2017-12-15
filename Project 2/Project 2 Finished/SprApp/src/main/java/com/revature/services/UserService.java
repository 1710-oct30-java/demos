package com.revature.services;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoHibernate;
import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.utilities.Password;

@Service
public class UserService {

	@Autowired
	Password pHash;
	@Autowired
	UserDao ud;// = new UserDaoHibernate();

	public void addUser(User u) {
		String tempPass = u.getPassword();
		try {
			byte[] salt = pHash.getSalt();
			String hashedPass = pHash.getSecurePassword(tempPass, salt);
			u.setPassword(hashedPass);
			u.setSalt(salt);

			ud.addUser(u);

		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public User validateAccount(User user) {
		System.out.println(user);
		User u = ud.findByUsername(user.getUsername());

		if (u == null) {
			return null;
		} else {
			byte[] salt = u.getSalt();
			String newPass = pHash.getSecurePassword(user.getPassword(), salt);

			if (newPass.equals(u.getPassword())) {
				return u;
			} else {
				return null;
			}
		}
	}

	public List<User> getAllUsers() {

		return ud.getAllUsers();
	}

	public Set<Review> getUsersReviewsByUserId(int i) {
		return ud.getUserById(i).getReviews();
	}
	
    public User getUserById(int id) {
    	System.out.println("trying to get user " + id);
        return ud.getUserById(id);
    }
}
