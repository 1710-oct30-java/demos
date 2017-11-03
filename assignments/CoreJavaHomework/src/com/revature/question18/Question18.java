package com.revature.question18;
/*
 * Write a program having a concrete subclass that inherits three
 * abstract methods from a superclass. Provide the following three implementations
 * in the subclass corresponding to the abstract methods in the superclass:
 * 
 * 1. Check for uppercase characters in a string, and return 'true' or 'false'
 * 	  depending if any are found
 * 2. Convert all of the lower case characters to uppercase in the input string, and
 * return the result
 * 3. Convert the input string to integer and add 10, output the result to the console
 */

//superclass with three abstract methods - superclass
public abstract class Question18 {
	//first method
	public abstract boolean firstMethod(String str);
	
	//second method
	public abstract String secondMethod(String str);
	
	//third method
	public abstract void thirdMethod(String str);
	
	
}
