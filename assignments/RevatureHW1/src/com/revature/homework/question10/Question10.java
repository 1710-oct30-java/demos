package com.revature.homework.question10;
// find the minimum of two numbers using ternary operators
public class Question10 {
public static void main(String[] args) {
	int a=5;
	int b=10;
	// checks and stores the smaller value
	int minVal = (a < b) ? a : b;
	System.out.println(minVal);
}
}
