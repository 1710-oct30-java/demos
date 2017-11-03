package com.revature.homework.question2;
// Display the first 25 nums of Fibonaccis sequence
public class Question2 {
public static void main(String[] args) {
	
	for(int i=0;i<25;i++) {
		System.out.println(fibNum(i));
	}
}
	public static int fibNum(int n) {
	// formula for fib's sequence with n as the iteration 
	// F(n) = ((((1+sqrt(5))/2)^n))-(((1-sqrt(5))/2)^n)))/sqrt(5)
	int sequenceNum = (int) ((Math.pow(((1+Math.sqrt(5))/2),n) - Math.pow(((1-Math.sqrt(5))/2),n))/Math.sqrt(5));
	return sequenceNum;
	}
}
