package com.revature.repos;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

	public void repoMethod1() {
		
	}

	public String repoMethod2() {
		return "what???";
	}
	
	public int repoMethod3(String str, int i) throws Exception {
		throw new Exception();
	}
}
