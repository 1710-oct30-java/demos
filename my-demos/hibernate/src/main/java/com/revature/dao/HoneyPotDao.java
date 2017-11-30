package com.revature.dao;

import java.util.List;

import com.revature.entities.HoneyPot;

public interface HoneyPotDao {
	List<HoneyPot> findByHoneyAmountGreaterThan(double amount);

	List<HoneyPot> findbyIdBetween(int one, int two);

	List<HoneyPot> findAllEmpty();
}
