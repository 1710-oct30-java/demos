// Christopher Youngblood
// 11/1/2017
// Revature Java Course
// Homework 1 - Question 15

package com.revature.javahw.q15;

// Q15. Write a program that defines an interface having the
//		following methods: addition, subtraction, multiplication,
//		and division. Create a class that implements this interface
//		and provides appropriate functionality to carry out the
//		required operations. Hard code two operands in a test
//		class having a main method that calls the implementing class.


public interface SimpleMath<E>{
	E addition(E... args);
	E subtraction(E... args);
	E multiplication(E... args);
	E division(E... args);
}