package com.revature.question11;

import com.revature.question11two.*;
/*
 * Access two float variables from a class that exists in another package
 * Second package is com.revature.Question11Two
 */

public class Question11 {

	public static void main(String[] args) {
		System.out.println(Question11Two.first + " " + Question11Two.second);
		
	}

}
