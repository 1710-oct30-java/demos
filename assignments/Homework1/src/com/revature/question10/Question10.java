package com.revature.question10;

import java.util.Scanner;

/*
 * Find the minimum of two numbers using ternary operators
 */

public class Question10 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter first int: ");
		int first = scanner.nextInt();
		System.out.println("Enter second int: ");
		int second = scanner.nextInt();
		
		int min = (first < second) ? first : second;
		
		System.out.println(min + " is the minimum value");

	}

}
