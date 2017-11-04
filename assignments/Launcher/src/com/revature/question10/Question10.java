package com.revature.question10;

public class Question10 {

	public static void findMin(int a, int b) {
		
		// Calculate the minimum
		int min = (a < b) ? a:b;
		System.out.println(min + " is the minimum of the two numbers");
	}
	
	public static void main(String[] args) {
		findMin(1,2);
	}

}
