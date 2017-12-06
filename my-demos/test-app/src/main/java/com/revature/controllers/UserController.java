package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Credential;
import com.revature.entities.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService us;

	@GetMapping
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User(1, new Credential("user", "pass")));
		users.add(new User(2, new Credential("admin", "admin")));
		users.add(new User(3, new Credential("blake", "p4ssw0rd")));

		return users;
	}

	@GetMapping("{id}/{other}")
	public User findById(@PathVariable int id, @PathVariable String other) {
		System.out.println("request to find user with id:" + id);
		System.out.println(other);
		return null;
	}

	@PostMapping("login")
	public User login(@RequestBody Credential cred) {
		System.out.println(cred);
		return us.login(cred);
	}

	@PutMapping
	public User update(@RequestBody User u) {
		System.out.println("updating user:" + u);
		return u;
	}

	@PostMapping
	public User save(@RequestBody User u) {
		return us.save(u);
	}

}
