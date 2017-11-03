package com.revature.question10;
	//find the minimum of two numbers using ternary operators

public class Question10 {
	public static void main(String[] args) {
		//call the minimum function
		System.out.println(minimum(10, 5));
		
	}
	
	/*
	 * function to determine the minimum number from two numbers
	 */
	public static int minimum(int firstNum, int secondNum) {
		return (firstNum < secondNum) ? firstNum : secondNum;
	}
}
