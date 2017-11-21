//Author: Micah West
//Date: 10/31/2017
//Purpose: Load an array with the values 1-100, print all evens using an enhanced for loop. 
//         Solution to Question 12.
//Included files: PrintEvens.java
//Input: none
//Output: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, ... 


package com.revature.corejava.Q12;

public class PrintEvens {
	
	public static void main(String[] args) {
		
		int aryInts[] = new int[100];
		
		// Fill the array
		for(int i = 0; i < 100; i++) {
			
			aryInts[i] = i+1;
		}
		
		// Iterate through the array and print even values.
		for(int element: aryInts) {
			
			if(element % 2 == 0) {
				
				System.out.print(element + ", ");
			}
		} // end for
	} // end main
}
