package com.revature.dao;

import java.util.List;

import com.revature.entities.Bear;

public interface Beardao {
	// C
	Bear save(Bear b);
	Bear persist(Bear b);
	
	// R
	Bear get(int id);
	Bear load(int id);
	
	// U
	Bear update(Bear b);
	Bear merge(Bear b);
	
	// D
	boolean delete(Bear b);
	
	
	// custom queries
	List<Bear> findByColorHQL(String color);
	List<Bear> findByColorCriteria(String color);
	List<Bear> findAll();
	
	List<Bear> findByHoneyPotAmountGreaterThan(double amount);
}
