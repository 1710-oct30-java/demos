package com.revature.Homework1.Q4;

public class Q4 {
//compute N factorial
	public static void main(String[] args) {
		int n = 6;
		System.out.println("N: "+ n +" Factorial: " + Factorial(n));
	}
	public static int Factorial(int n) {
		if(n == 0) {
			return 1;
		}
		return(n * Factorial(n-1));
	}

}
