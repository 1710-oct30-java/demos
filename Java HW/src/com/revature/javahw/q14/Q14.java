// Christopher Youngblood
// 10/31/2017
// Revature Java Course
// Homework 1 - Question 14

package com.revature.javahw.q14;

import java.util.Date;

// Q14. Write a program that demonstrates the switch case. 
//      Implement the following functionalities in the cases:
//	Case 1: Find the square root of a number using the Math class method.
//	Case 2: Display today's date.
//	Case 3: Split the following string and store it in a string array.
//			"I am learning Core Java"

public class Q14 {
	public static void main(String[] args) {
		//insert however the case is being determined
		int x = 3;
		
		//Variables/objects to work on in the cases
		int numb = 4;
		Date date = new Date();
		String str = "I am learning Core Java";
		
		switch (x) {
		case 1:
			//prints the square root
			System.out.println(Math.sqrt(numb));
			break;
			
		case 2:
			System.out.println(date.toString());
			break;
			
		case 3:
			String[] str2 = str.split(" ");

			for(String ele : str2) {
				System.out.println(ele);
			}
			break;
		}
	}
}