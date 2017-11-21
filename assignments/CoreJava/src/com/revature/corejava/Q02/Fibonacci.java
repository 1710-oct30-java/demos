//Author: Micah West
//Date: 11/01/2017
//Purpose: Compute the first 25 values of the Fibonacci sequence.
//Included files: Fibonacci.java
//Input: none
//Output: First 25 fibonacci numbers, beginning from 0:
//        0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 

package com.revature.corejava.Q02;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		System.out.println("First 25 fibonacci numbers, beginning from 0:");
		
		for(int i = 0; i < 25; i++) {
			
			System.out.print(fibonacci(i) + ", ");
			
		}
	}
	
	public static int fibonacci(int n) {
		
		if(n < 1) {
			return 0;
		}
		
		else if(n <= 2) {
			return 1;
		}
		
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
