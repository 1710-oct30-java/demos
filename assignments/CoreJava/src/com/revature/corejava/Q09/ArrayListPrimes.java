//Author: Micah West
//Date: 10/31/2017
//Purpose: Fill an array list with integers 1-100, print all the primes. Solution to Question 9.
//Included files: ArrayListPrimes.java
//Input: none
//Output: 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 

package com.revature.corejava.Q09;

import java.util.ArrayList;

public class ArrayListPrimes {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		for(int i = 0; i < 100; i++) {
			
			intList.add(i+1);
		}
		
		for(Integer element: intList) {
			
			if(isPrime(element.intValue())) {
				
				System.out.print(element.intValue() + ", ");
			}
		}
		
	}
	
	public static boolean isPrime(int n) {
		
		for(int i = 2; i < n; i++) {
			
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
}
