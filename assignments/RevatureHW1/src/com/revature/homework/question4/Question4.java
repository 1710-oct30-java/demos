package com.revature.homework.question4;

// Write a program to compute N factorial

public class Question4 {
	public static void main(String[] args) {
		System.out.println(computeFactorial(5));
	}
	
	public static int computeFactorial(int num) {
		// initialize factorial to one so that it doesn't mult by 0
		int factorial=1;
		
		// decrementing for loop until num is 0. multiplies itself after each decrement
		for ( ; num>0;num--) {
			factorial = factorial*num;
		}
		return factorial;
	}
}
