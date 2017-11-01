//Author: Micah West
//Date: 10/31/2017
//Purpose: Runs methods implemented in the class ConcreteMethods extended from the abstract 
//		   class AbstractMethods. These are tested on constant strings.
//		   findUpperCase returns true if a given string contains an uppercase letter
//         toUpperCase returns the given string with all uppercase letters
//		   stringNumPlusTen converts a given string number, adds ten to it, and prints it to the console
//		   Part of the solution to Question 18.
//Included files: AbstractMethods.java, ConcreteMethods.java, ConcreteMethodsLauncher.java
//Input: none
//Output: camelCase has an uppercase letter.
//        camelCase becomes CAMELCASE
//		  Input: 93
//		  93 + 10 = 103

package com.revature.corejava.Q18;

public class ConcreteMethodsLauncher {
	
	public static void main(String[] args) {
		
		// Instantiate the ConcreteMethods class because none of the methods within
		// that class are static.
		ConcreteMethods methods = new ConcreteMethods();
		
		// Define some quick testing strings to use on the methods in the above class.
		final String INPUT_1 = "camelCase";
		final String INPUT_2 = "lowercase";
		final String INPUT_3 = "UPPERCASE";
		final String INPUT_4 = "93";
		
		// All the following is testing the functions in the order listed in the question
		// and also in the file's heading.
		System.out.println("Testing ConcreteMethods.findUpperCase:");
		
		if(methods.findUpperCase(INPUT_1)) {
			
			System.out.println(INPUT_1 + " has an uppercase letter.");
		}
		else {
			
			System.out.println(INPUT_1 + " does not have an uppercase letter.");
		}
		
		if(methods.findUpperCase(INPUT_2)) {
			
			System.out.println(INPUT_2 + " has an uppercase letter.");
		}
		else {
			
			System.out.println(INPUT_2 + " does not have an uppercase letter.");
		}
		
		System.out.println("\nTesting ConcreteMethods.toUpperCase:");
		System.out.println(INPUT_1 + " becomes " + methods.toUpperCase(INPUT_1));
		System.out.println(INPUT_2 + " becomes " + methods.toUpperCase(INPUT_2));
		System.out.println(INPUT_3 + " becomes " + methods.toUpperCase(INPUT_3));
		
		System.out.println("\nTesting ConcreteMethods.stringNumPlusTen:");
		System.out.println("Input: " + INPUT_4);
		methods.stringNumPlusTen(INPUT_4);
	}
	
}
