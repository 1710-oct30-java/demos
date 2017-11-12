/*
 * Question 11
 * Write a program that would access two floats from a class that exists in another package. 
 * Note, you will need to create two packages to demonstrate this solution.
 * By: Brice Petty
 * Credit To: 
 * The TestFloat class I am retreiving floats from is in the com.revature.question11.testfloats package if you're looking for it
 */
package com.revature.question11;

import com.revature.question11.testfloats.TestFloats;

public class ClassInteraction {
	public static void main(String[] args) {
		System.out.println(TestFloats.getFloatA() + " is Float A");
		System.out.println(TestFloats.getFloatB() + " is Float B");
	}
}