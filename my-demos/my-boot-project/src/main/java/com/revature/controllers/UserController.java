package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Credential;
import com.revature.entities.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService us;

	@GetMapping
	public List<User> findAll() {
		return us.findAll();
	}

	@GetMapping("startswith/{letter}")
	public List<User> usernameStartsWith(@PathVariable String letter) {
		return us.usernameStartsWith(letter);
	}

	@GetMapping("idbetween/{one}/{two}")
	public List<User> findByIdBetween(@PathVariable int one, @PathVariable int two) {
		return us.findByIdBetween(one, two);
	}

	@PostMapping("login")
	public User login(@Valid @RequestBody Credential cred) {
		return us.login(cred);
	}

	@PostMapping
	public User save(@RequestBody User u) {
		return us.save(u);
	}

}
