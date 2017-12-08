package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Credential;
import com.revature.entities.User;
import com.revature.exceptions.CustomHttpException;
import com.revature.exceptions.InvalidCredentialException;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService us;

	@GetMapping
	public List<User> getAllUsers() {
		return us.findAll();
	}

	@GetMapping("{id}/{other}")
	public User findById(@PathVariable int id, @PathVariable String other) {
		System.out.println("request to find user with id:" + id);
		System.out.println(other);
		return null;
	}

	@PostMapping("login")
	public User login(@RequestBody Credential cred) throws InvalidCredentialException {
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

	@GetMapping("nested")
	public void nested() {
		us.saveTwo(new User(0, new Credential("john", "pass")), new User(0, new Credential("mitch", "pass")));
	}

	@ExceptionHandler(CustomHttpException.class)
	public ResponseEntity<String> customExceptionHandler(CustomHttpException e, HttpServletRequest req) {
		System.out.println(req.getMethod());
		ResponseEntity<String> resp = new ResponseEntity<>(e.getMessage(), e.getStatus());
		return resp;
	}

}
