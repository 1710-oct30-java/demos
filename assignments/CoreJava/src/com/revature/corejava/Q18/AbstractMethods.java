//Author: Micah West
//Date: 10/31/2017
//Purpose: Create an abstract class containing a set of methods that operate on strings.
//		   findUpperCase returns true if a given string contains an uppercase letter
//         toUpperCase returns the given string with all uppercase letters
//		   stringNumPlusTen converts a given string number, adds ten to it, and prints it to the console
//		   Part of the solution to Question 18.
//Included files: AbstractMethods.java, ConcreteMethods.java, ConcreteMethodsLauncher.java
//Input: none
//Output: none

package com.revature.corejava.Q18;

public abstract class AbstractMethods {
	
	public abstract boolean findUpperCase(String input);
	public abstract String toUpperCase(String input);
	public abstract void stringNumPlusTen(String input);
}
