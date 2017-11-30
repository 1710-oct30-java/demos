package com.revature.dao;

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
	Bear findByColor(String color);
}
