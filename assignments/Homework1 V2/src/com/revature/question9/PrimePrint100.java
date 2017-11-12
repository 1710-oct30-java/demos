/*
 * Question 9
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
 * By: Brice Petty
 * Credit To: 
 */
package com.revature.question9;

import java.util.ArrayList;

public class PrimePrint100 {
	public static boolean testPrime(int n) {
		if (n % 2 == 0) {
			return false;
		} //anything that is even is automatically NOT prime
		
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) { 
				return false;
			}
		}
		return true;
	} //Try dividing our int by all possible odd values between 3 and the square root of N. If N is divisible by 2 we've already returned 
	  //false. This means we will only test possibilities once. This saves operations and makes things efficient and clean

	static ArrayList<Integer> theList() {
		ArrayList<Integer> aList = new ArrayList<Integer>();

		for (int i = 1; i <= 100; i++) {
			aList.add(i);
			if (testPrime(aList.get(i - 1))) {
				System.out.println(i + " is a prime");
			}
		}
		return aList;
	}
	
	public static void main(String[] args) {
		theList();
	}
}