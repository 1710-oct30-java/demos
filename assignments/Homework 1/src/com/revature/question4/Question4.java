package com.revature.question4;

import java.util.Scanner;

public class Question4 {
	
	public void factorialize (int inputN) {
		
	  int x;
	  int factorial = 1;
	  for ( x = inputN; x > 1; x--)
	     factorial *= x;
	  System.out.println("the factorial of your input integer is " + factorial);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Please input an integer N");
		Scanner inputN = new Scanner(System.in);
		int n = inputN.nextInt();
		Question4 factorialThisN = new Question4();
		factorialThisN.factorialize(n);
		inputN.close();
		
	}
}
