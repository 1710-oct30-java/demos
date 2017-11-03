package com.revature.question2;
/*
 * Write a program to display the first 25 Fibonacci numbers beginning at 0
 */

public class Question2 {

	public static void main(String[] args) {
		//Formula for the fibonacci: Fn = Fn-1 + Fn-2
		//F0 = 0, F1 = 1
		int fib0 = 0;
		int fib1 = 1;
		
		System.out.println("1. " + fib0);	//Print the first number of the fibonacci series
		System.out.println("2. " + fib1);	//Print the second number of the fibonacci series
		
		//Since the first two numbers of the fibonacci series where printed already for loop 
		//prints the next 23 numbers
		for (int i = 3; i <= 25; i++) {
			int fib = fib0 + fib1;	//fib is equal to the sum of the previous two numbers
			System.out.println( i + ". " + fib);
			//change the values of fib0 and fib1 to recalculate the next fibonacci number
			fib0 = fib1;
			fib1 = fib;
			
		}
		
	}
	
}
