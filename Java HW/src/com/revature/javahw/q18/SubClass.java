// Christopher Youngblood
// 11/1/2017
// Revature Java Course
// Homework 1 - Question 18

package com.revature.javahw.q18;

// Q18. Write a program having a concrete subclass that inherits
// 		three abstract methods from a superclass. Provide the
//		following three implementations in the subclass
//		corresponding to the abstract methods in the superclass:
//
//	1. Check for uppercase characters in a string, and return
//		true or false depending on if any were found.
//	2. Convert all of the lower case characters to uppercase in
//		the input string, and return the result.
//	3. Convert the input string to integer and add 10, output
//		the result to console.
//
//		Create an appropriate class having a main method to test
//		the above setup.
public class SubClass extends SuperClass {


	public SubClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	boolean uppercaseCheck(String s) {
		if (s.toLowerCase().equals(s)) {
			return false;
		}
		return true;
	}

	@Override
	String lowerToUpper(String s) {
		return s.toUpperCase();
	}

	@Override
	void stringToIntegerAddTenDisplay(String s) {
		System.out.println((Integer.parseInt(s) + 10));
		
	}

}
