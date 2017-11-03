package com.revature.question6;

import java.util.Scanner;

/*
 * Program to determine if an int is even without using % operator
 */

public class Question6 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter int for n:");
		int n = scanner.nextInt();
		
		if (n == 1)
			System.out.println("Number is odd");
		else if ((n/2)*2 == n)
			System.out.println("Number is even");
		else
			System.out.println("Number is odd");
	}

}
