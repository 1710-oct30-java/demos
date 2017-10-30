package com.revature.Homework1.Q2;

public class Q2 {
	//print first 25 Fibonacci numbers; starting at 0
	public static void main(String[] args) {
		for(int i = 0; i < 25; i++) {
			System.out.println("n: "+ i + " Fibonacci: " + Fibonacci(i));
		}
	}
	public static int Fibonacci(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return(Fibonacci(n-1) + Fibonacci(n-2));
		
	}
}
