package com.revature.banking;

import java.io.Serializable;

public class User implements Serializable {
	public String name;
	
	public User(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}
}
