package com.revature;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.revature.entities.User;

public class RestTemplateExample {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Set> response = restTemplate.getForEntity("http://localhost:8080/test-app/users", Set.class);
		Set<User> users = response.getBody();

		System.out.println(users);
		System.out.println(users.getClass());
	}
}
