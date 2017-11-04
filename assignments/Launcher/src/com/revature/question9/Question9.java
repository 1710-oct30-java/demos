package com.revature.question9;

import java.util.ArrayList;

public class Question9 {
	
	// Checks whether a number is prime.
	// If there is any number between
	// 2 and n that n can be evenly
	// divided by, then that means
	// n has factors other than 1 and n,
	// which would make n be not prime
	public static boolean isPrime(int n) {
		for (int i=2; i < n;i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		// Create the ArrayLists
		ArrayList<Integer> al = new ArrayList<Integer>(100);
		ArrayList<Integer> pal = new ArrayList<Integer>();
		
		// Set the values of the ArrayList
		for (int i = 1; i < 101;i++) {
			al.add(i);
			
			// Add prime numbers to the prime ArrayList
			if(isPrime(al.get(i-1))) {
			pal.add(al.get(i-1));
			}
		}
		System.out.println(pal);
	}
}
