package com.revature.dao;

import java.util.List;

import com.revature.entities.HoneyPot;

public interface HoneyPotDao {

	List<HoneyPot> findHoneyPotAmountBetween(double from, double to);
	
}
