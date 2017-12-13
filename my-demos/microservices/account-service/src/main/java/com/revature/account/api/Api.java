package com.revature.account.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.account.entities.Account;

@RestController
@RequestMapping("accounts")
public class Api {
	private List<Account> accounts;

	public Api() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1, 1, "account1", 50));
		accounts.add(new Account(2, 3, "account1", 500));
		accounts.add(new Account(3, 2, "account1", 521));
		accounts.add(new Account(4, 1, "account1", 521));
		accounts.add(new Account(5, 2, "account1", 1000));
	}

	@GetMapping
	public List<Account> test() {
		return accounts;
	}

	@GetMapping("{id}")
	public Account findById(@PathVariable int id) {
		return accounts.stream().filter(account -> account.getId() == id).findFirst().get();
	}

	@GetMapping("customer/{id}")
	public List<Account> findByCustomer(@PathVariable int id) {
		return accounts.stream().filter(account -> account.getCustomerId() == id).collect(Collectors.toList());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
