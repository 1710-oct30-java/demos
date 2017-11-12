/*
 * Question 4
 * Write a program to compute N factorial.
 * By: Brice Petty
 * Credit To: 
 */
package com.revature.question4;

import java.util.Scanner;

public class NFactorial {
	public static double factorialize(int inputN) {
		double factorial = 1; //changed to double so we can return the computed factorial for larger inputs

		for (int i = inputN; i > 1; i--) {
			factorial *= i;
		}
		return factorial;
	}

	public static void main(String[] args) {
		System.out.println("Please provide an integer N for factorialization: ");
		Scanner n = new Scanner(System.in);
		int inputN = n.nextInt();
		System.out.println(factorialize(inputN));
		n.close();
	}
}
