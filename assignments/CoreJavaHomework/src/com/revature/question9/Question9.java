package com.revature.question9;

import java.util.ArrayList;
import java.util.List;

/*
 * Create an ArrayList which stores numbers from 1 to 100
 * and prints out all the prime numbers to the console
 */
public class Question9 {
	public static void main(String[] args) {

		// Create the ArrayList to store numbers from 1 to 100
		List<Integer> numList = new ArrayList<>();
		// loop to add the numbers (1-100) to the list
		for (int i = 1; i <= 100; i++) {
			numList.add(i);
			// print all the numbers that are prime
			if (prime(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean prime(int n) {
		/*
		 * //prime - can be divided evenly only by 1 or itself and must be greater than
		 * 1 if n is less than 2 it is not prime, if it can be divided by another number
		 * other than 1 or n and the remainder is 0 then it is not prime. If it passes
		 * those two tests then it is prime
		 */
		if (n < 2) {
			return false;
		} else {
			for (int i = 2; i < n; i++) {
				if (n % i == 0)
					return false;
			}
		}
		return true;
	}
}
