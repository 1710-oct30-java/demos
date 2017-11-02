package com.revature.javacore.question18;

/*
	Write a program having a concrete subclass that inherits three abstract methods
	from a superclass. Provide the following three implementations in the subclass
	corresponding to the abstract methods in the superclass:
		1. Check for uppercase characters in a string, and return 'true' or 'false' depending
		   if any are found.
		2. Convert all of the lower case characters to uppercase in the input string, and
		   return the result.
		3. Convert the input string to integer and add 10, output the result in the console.
 	Create an appropriate class have a main method to test the above setup.
 */

public class Question18
{
	public static void main(String[] args)
	{
		Converter c = new Converter();
		
		String str = "This is Some input for this Class.";		
		System.out.println(c.hasUpperCase(str) + "\n");
		System.out.println(c.toUpperCase(str) + "\n");
		
		String str2 = "512";
		String str3 = "  5.!@#$%^&*1()_-azq`~ 2 ";
		
		c.convertToIntAndAddTen(str2);
		c.convertToIntAndAddTen(str3);
	}
}
