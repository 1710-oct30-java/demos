// Christopher Youngblood
// 10/30/2017
// Revature Java Course
// Homework 1 - Question 9

package com.revature.javahw.q9;

import java.util.ArrayList;

// Q9. Create an ArrayList which stores numbers from 1 to 100 
//     and prints out all the prime numbers to the console

public class Q9 {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		//populate numbers
		for (int i = 1; i <= 100; i++) {
			numbers.add(i);
		}
		
		//print all prime numbers to the console
		for (int i = 1; i < 100; i++) {
			
			//avoid math issues in the next loop
			if (numbers.get(i) <= 3) {
				System.out.println(i);
			}
			//if any number other than 1 that is smaller than
			//the test number divides evenly into the test number,
			//the test number is is marked as non-prime.
			else {
				boolean prime = true;
				for (int j = 2; j < i; j++) {
					if((i % j) == 0) {
						prime = false;
					}
				}
				//Print the number if it is prime
				if (prime) {
					System.out.println(i);
				}
				
			}
		}
	}
}
