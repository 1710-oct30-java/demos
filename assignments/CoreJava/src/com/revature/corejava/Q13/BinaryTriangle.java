//Author: Micah West
//Date: 10/31/2017
//Purpose: Display the triangle as shown in the Core Java homework handout using a for loop.
//         Solution to Question 13
//Included files: BinaryTriangle.java
//Input: none
//Output: none

package com.revature.corejava.Q13;

public class BinaryTriangle {
	
	public static void main(String[] args) {
		
		// Two counters to keep track of when to print a next line.
		// The first is a count of the number of values to print before the next line
		// the other is the amount that will be assigned to the base counter every time
		// a new line is printed.
		int counter = 1;
		int startCount = 1;
		
		for(int i = 0; i < 10; i++) {
			
			if(counter == 0) {
				
				System.out.println("");
				startCount++;
				counter = startCount;
			}
			counter--;
			System.out.print(i%2);
		}
	}
}
