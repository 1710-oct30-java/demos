package com.revature.question6;

public class Question6 {
	public static void isEven(int n) {
		int quotient = n/2;
		if (n == quotient * 2)
			System.out.println(n + " is even");
		else {
			System.out.println(n + "is odd");
		}
	}
	
	public static void main(String[] args) {
		isEven(8);
	}

}
