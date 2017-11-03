package com.revature.question4;

public class Question4 {

	// Calculate factorial of a given number
	public static int nFactorial(int n) {
		int product = 1;
		for (int i = n; i > 0;i--) {
			product *= i;
		}
		return product;
	}
	
	
	public static void main(String[] args) {
		//Print the answer to the console
		System.out.println("The factorial is " + nFactorial(5));
	}
}
