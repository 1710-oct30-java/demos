/*
 * Question 14
 * Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division. 
 * Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
 * Hard code two operands in a test class having a main method that calls the implementing class.
 * By: Brice Petty
 * Credit To:
 */
package com.revature.question15;

import com.revature.question15.Q15Calculator;

public class MathInterface {
	public static void main(String[] args) {
		double a = 7;
		double b = 3.5;
		Q15Calculator calc = new Q15Calculator();
		System.out.println(calc.add(a, b));
		System.out.println(calc.subtract(a, b));
		System.out.println(calc.multiply(a, b));
		System.out.println(calc.divide(a, b));
	}
}