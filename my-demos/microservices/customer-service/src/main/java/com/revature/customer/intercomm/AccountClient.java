package com.revature.customer.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.customer.entities.Account;

@FeignClient("account-service")
public interface AccountClient {

	@GetMapping("/accounts/customer/{id}")
	List<Account> getAccountsByCustomer(@PathVariable("id") int id);

}
