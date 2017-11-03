package com.revature.question18;

import java.util.Scanner;

/*
 * Write a program having a concrete subclass that inherits three abstract methods from
 * a superclass. Provide following 3 implementations in the subclass corresponding
 * to the abstract methods in the superclass
 * 
 * 1. Check for uppercase characters in a string, and return 'true' or 'false' depending if
 * any are found
 * 2. Convert all of the lower case characters to uppercase in the input string, and return
 * the result
 * 3. Convert the input string to integer and add 10, output the result to the console
 */

public class Question18 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your string: ");
		String s = scanner.nextLine();
		
		System.out.println("Enter your int string: ");
		String s2 = scanner.nextLine();
		Question18Sub go = new Question18Sub();
		
		Boolean one = go.uppercase(s);
		String two = go.lowercaseString(s);
		int three = go.convertString(s2);
		
		System.out.println("1: " + one);
		System.out.println("2: " + two);
		System.out.println("3: " + three);

	}

}
