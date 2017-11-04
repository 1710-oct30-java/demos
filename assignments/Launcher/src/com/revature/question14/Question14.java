package com.revature.question14;

import java.util.Date;

public class Question14 {

	public static void main(String[] args) {
		int test = 1;
		
		switch (test) {
		
			// perform different cases depending on the input test variable
			case 1: 
					System.out.println("The square root is " + Math.sqrt(100));
					System.out.println();
					break;
			
			case 2: 
					// Create a Date object and print it as a string
					Date d = new Date();
					System.out.println(d.toString());
					break;
			
			case 3: 
					// split the string into an array of strings
					// using the whitespace as a delimiter
					String s = "I am learning Core Java";
					String[] stringArray = s.split(" ");
					
					for (String str : stringArray)
						System.out.println(str);
					
					break;
					
			default: break;
		}
	}
	
}
