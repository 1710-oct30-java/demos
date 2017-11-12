/*
 * Question 19
 * By: Brice Petty
 * Create an ArrayList and insert integers 1 through 10. Disply the ArrayList. Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 * Credit To:
 */

package com.revature.question19;

import java.util.ArrayList;
import java.util.List;
import com.revature.question9.PrimePrint100; //reuse the test prime method. I don't want to write it again

public class ArrayListTinkering {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		int evenCount = 0;
		int oddCount = 0;
		
		for (int i = 0; i < 10; i++) {
			numList.add(i + 1);
		} //populate the array list with 1 through 10
		
		for (int i : numList) {
			if (i % 2 == 0) {
				evenCount += i;
			} //count up the evens
			else {
				oddCount += i;
			} //count up the odds
		}

		for (int i = 0; i < numList.size(); i++) {
			if (PrimePrint100.testPrime(numList.get(i)))
				numList.remove(i);
		} //remove the primes from the list after everything has been counted
		
		System.out.println("The count of evens in the list is: " + evenCount);
		System.out.println("The count of odds in the list is: " + oddCount);
		System.out.println("The non-primes in the list are: " + numList);
	}
}