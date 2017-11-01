// Christopher Youngblood
// 10/31/2017
// Revature Java Course
// Homework 1 - Question 12

package com.revature.javahw.q12;

import java.util.ArrayList;

// Q12. Write a program to store numbers from 1 to 100 in an
//      array. Print out all the even numbers from the array.
//      Use the enhanced FOR loop for printing out the numbers.

public class Q12 {
	public static void main(String[] args) {
		ArrayList<Integer> one2Hundred = new ArrayList<Integer>();
		for(int i = 1; i < 101; i++) {
			one2Hundred.add(i);
		}
		
		for(int ele: one2Hundred) {
			if ((ele%2) == 0) {
				System.out.println(ele);
			}
		}
	}
}
