//Author: Micah West
//Date: 10/31/2017
//Purpose: Perform three different functions based on a switch case. Solution to question 14.
//Included files: CaseTester.java
//Input: none
//Output: Case 1:
//		  Square root of 16.0 is 4.0
//
//		  Case 2:
//		  Today's date is 10/31/2017.
//		
//		  Case 3:
//		  String "I am learning Core Java" split into:
//		  [I, am, learning, Core, Java]

package com.revature.corejava.Q14;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CaseTester {
	
	public static void main(String[] args) {
		
		// I'm wrapping this in a for loop so that there is output.
		for(int which = 1; which <= 3; which++) {
			
			System.out.println("Case " + which + ":");
			switch(which) {
			
			case 1:
				// Square root calculation
				double number = 16;
				System.out.println("Square root of " + number + " is " + Math.sqrt(number));
				break;
				
			case 2:
				// Today's date. Scales with time.
				// Obtained from https://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
				// I wasn't sure how so I googled it and rewrote the code.
				// It makes me sad because the method I previously used for 
				// scaling date and time doesn't work in Java 8.
				DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDateTime today = LocalDateTime.now();
				String strDate = dtfDate.format(today);
				
				System.out.println("Today's date is " + strDate + ".");
				break;
				
			case 3:
				// String splitting
				String input = "I am learning Core Java";
				String inputSplit[] = input.split(" ");
				
				System.out.println("String \"" + input + "\" split into:");
				System.out.println(Arrays.toString(inputSplit));
				break;
			}
			// Print a new line
			System.out.println("");
		}
	}
}
