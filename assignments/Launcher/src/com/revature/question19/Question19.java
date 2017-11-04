package com.revature.question19;

import java.util.ArrayList;


public class Question19 {
	
	// Check whether a number is prime or not
	// depending on if it has factors between
	// 1 and 9 exclusive
	static boolean checkPrime(int n) {
		for (int i=2; i < n;i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>(10);
		ArrayList<Integer> oal = new ArrayList<Integer>();
		ArrayList<Integer> eal = new ArrayList<Integer>();
		ArrayList<Integer> pal = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			
			// Adds values to the original ArrayList
			al.add(i);
			
			// Adds values to the even ArrayList
			if (i%2 == 0) {
				eal.add(i);
			}
			
			// Adds values to the odd ArrayList
			else {
				oal.add(i);
			}
			
			// Performs the checkPrime() method and
			// adds the value to the prime ArrayList
			// if the number is a prime number
 			if(checkPrime(al.get(i-1))) {
				pal.add(al.get(i-1));
				}
		}
		
		// Print out each of the ArrayList objects
		System.out.println(al);
		System.out.println(eal);
		System.out.println(oal);
		System.out.println(pal);
		
	}

}
