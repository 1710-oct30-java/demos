// Christopher Youngblood
// 10/30/2017
// Revature Java Course
// Homework 1 - Question 11

package com.revature.javahw.q11;

import com.revature.javahw.q11_2.Q11_2;

// Q11. Write a program that would access two float-variables from
//      a class that exists in another package.

public class Q11 {	
	public static void main(String[] args) {
		Q11_2 package1 = new Q11_2();
		
		System.out.println("Float 1: " + package1.flt1 + ", Float2: " +  package1.flt2);
	}
}
