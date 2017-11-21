//Author: Micah West
//Date: 10/31/2017
//Purpose: Place numbers 1-10 in an ArrayList, display the list,
//		   add all odd numbers, add all even numbers, remove prime numbers
//		   print the resulting list.
//Included files: ArrayListLauncher.java
//Input: none
//Output: Starting list:
//		  [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
//		  Total of all odd numbers: 30
//		  Total of all even numbers: 25
//		  Final list without primes: 
//		  [4, 6, 8, 9, 10]

package com.revature.corejava.Q19;

import java.util.ArrayList;

public class ArrayListLauncher {

	public static void main(String[] args) {
		
		// Create two array lists, one that will be modified
		// and one that will hold the prime numbers while the
		// program iterates through the initial integer list.
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<Integer> primesList = new ArrayList<Integer>();
		
		// Storing the totals in two-index array for quick access.
		int totals[] = {0, 0};
		
		// Fill the array list, then print it
		for(int i = 0; i < 10; i++) {
			
			intList.add(new Integer(i+1));
		}
		
		System.out.println("Starting list:\n" + intList.toString());
		
		// I did these problems out of order, so this is my first time
		// actually making use of the enhanced for.
		// I remember seeing it and was told about its use, but never
		// learned how to use it until this class.
		for(Integer element: intList) {
			
			// Originally this was a simple if/else statement but
			// the action of adding i.intValue() to a total felt
			// redundant so I just made the totals an array since
			// the result of a % 2 operation will always fall within
			// 0 or 1
			totals[element.intValue() % 2] += element.intValue();
			
			// Additionally, while we have access to the element, add
			// it to the list of elements that need to be removed
			// from the main integer list
			if(isPrime(element.intValue())) {
				
				primesList.add(element);
			}
		}
		
		
		// Remove the prime numbers found in the previous for loop
		// from the main integer list.
		for(Integer element: primesList) {
			
			intList.remove(element);
		}
		
		// Print out the totals.
		System.out.println("Total of all odd numbers: " + totals[0]);
		System.out.println("Total of all even numbers: " + totals[1]);
		
		// Print the reduced list.
		System.out.println("Final list without primes: \n" + intList.toString());
		
	}
	
	// Additional method to determine if the number is prime.
	public static boolean isPrime(int n) {
		
		for(int i = 2; i < n; i++) {
			
			if(n % i == 0)
				return false;
		}
		return true;
	}
}
