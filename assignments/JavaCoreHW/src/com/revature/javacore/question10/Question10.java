package com.revature.javacore.question10;
/*
 	Find the minimum of two numbers using ternary operators.
*/
public class Question10 {

	public static void main(String[] args) {
		int num1 = 48;
		int num2 = 44;
		
		System.out.println(findMin(num1, num2));
	}
	
	// Method returns minimum of two numbers using ternary operators
	public static int findMin(int num1, int num2)
	{
		return num1 < num2 ? num1 : num2;
	}

}
