package com.revature.question4;
//Write a program to compute N factorial
public class Question4 {
	
	public static void main(String[] args) {
		System.out.println(factorial(6));
	}
	/*
	Factorial formula - n! = n * (n-1)!
	n! = 1 if n = 0 or n = 1
	6! = 6 x 5 x 4 x 3 x 2 x 1 = 720
	*/
	public static int factorial(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		
		return n * factorial(n - 1);
	}
	
}
