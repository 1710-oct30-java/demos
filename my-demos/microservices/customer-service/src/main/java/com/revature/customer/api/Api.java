package com.revature.customer.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.customer.entities.Customer;
import com.revature.customer.intercomm.AccountClient;

@RestController
@RequestMapping("customers")
public class Api {
	private List<Customer> customers;
	
	@Autowired
	private AccountClient ac;

	public Api() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "Chris W.", null));
		customers.add(new Customer(2, "John Brown", null));
		customers.add(new Customer(3, "Austin", null));
		customers.add(new Customer(4, "Stephen", null));
		customers.add(new Customer(5, "Kelton", null));
	}

	@GetMapping("{id}")
	public Customer findById(@PathVariable int id) {
		Customer customer = customers.stream().filter(cust -> cust.getId() == id).findFirst().get();
		customer.setAccount(ac.getAccountsByCustomer(id));
		return customer;
	}

}
