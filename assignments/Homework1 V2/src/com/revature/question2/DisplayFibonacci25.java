/*
 * Question 2
 * Write a program to display the first 25 Fibonacci numbers starting at 0
 * By: Brice Petty
 * Credit To: 
 */
package com.revature.question2;

import java.util.Arrays;

public class DisplayFibonacci25 {
	
	static private int fibonacciRecursion(int n)  {
	    if(n == 0)
	        return 0;
	    else if(n == 1)
	      return 1;
	   else
	      return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
	}
	
	static private int[] setFib25() {
		int[] fibSequenceTo25 = new int[25];
		
		for (int i = 0; i < 25; i++) {
			fibSequenceTo25[i] = fibonacciRecursion(i);
		}
		return fibSequenceTo25;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(setFib25()));
	}
}