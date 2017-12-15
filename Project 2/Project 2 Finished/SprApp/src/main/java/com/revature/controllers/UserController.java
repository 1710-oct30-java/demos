package com.revature.controllers;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService us;

	@PostMapping("login")
	public ResponseEntity<?> getUser(@RequestBody User uLog) {
		User u = null;
		System.out.println(uLog);
		u = us.validateAccount(uLog);// uReg.getUsername());

		if (u == null)
			return new ResponseEntity<>(new User(), HttpStatus.UNAUTHORIZED);
		else {
			System.out.println("matched");
			
			return new ResponseEntity<>(u, HttpStatus.OK);
		}

	}

	@PostMapping("register")
	public ResponseEntity<?> regUser(@RequestBody User uReg) {
//		uReg.setCreated(new Date());
		us.addUser(uReg);
		return new ResponseEntity<>(uReg, HttpStatus.OK);

	}
	
	@GetMapping("getReviews/{userId}")
	public Set<Review> getUsersReviewsByUserId(@PathVariable int userId) {
		return us.getUsersReviewsByUserId(userId);
	}
	


	// @GetMapping
	// public List<User> getAllUsers() {
	// List<User> users = new ArrayList<>();
	// users.add(new User(1, new Credential("user", "pass")));
	// users.add(new User(2, new Credential("admin", "admin")));
	// users.add(new User(3, new Credential("blake", "p4ssw0rd")));
	//
	// return users;
	// }
	//
	// @GetMapping("{id}/{other}")
	// public User findById(@PathVariable int id, @PathVariable String other) {
	// System.out.println("request to find user with id:" + id);
	// System.out.println(other);
	// return null;
	// }
	//
	// @PostMapping("login")
	// public User login(@RequestBody Credential cred) {
	// System.out.println(cred);
	// if ("user".equals(cred.getUsername()) &&
	// "password".equals(cred.getPassword())) {
	// return new User(11, cred);
	// } else {
	// return null;
	// }
	// }
	//
	// @PutMapping
	// public User update(@RequestBody User u) {
	// System.out.println("updating user:" + u);
	// return u;
	// }

}
