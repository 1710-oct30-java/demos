//Author: Micah West
//Date: 10/31/2017
//Purpose: Implements the functions defined in the abstract class AbstractMethods:
//		   findUpperCase returns true if a given string contains an uppercase letter
//         toUpperCase returns the given string with all uppercase letters
//		   stringNumPlusTen converts a given string number, adds ten to it, and prints it to the console
//		   Part of the solution to Question 18.
//Included files: AbstractMethods.java, ConcreteMethods.java, ConcreteMethodsLauncher.java
//Input: none
//Output: none

package com.revature.corejava.Q18;

public class ConcreteMethods extends AbstractMethods {

	@Override
	public boolean findUpperCase(String input) {
		
		// Iterate through the characters in the given string and 
		// check if it's uppercase
		for(int i = 0; i < input.length(); i++) {
			
			if(Character.isUpperCase(input.charAt(i))) {
				
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUpperCase(String input) {
		
		return input.toUpperCase();
	}

	@Override
	public void stringNumPlusTen(String input) {
		
		int value = Integer.parseInt(input);
		System.out.println(value + " + 10 = " + (value+10));
	}

}
