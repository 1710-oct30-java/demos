// Christopher Youngblood
// 11/1/2017
// Revature Java Course
// Homework 1 - Question 19

package com.revature.javahw.q19;

import java.util.ArrayList;
import java.util.List;

// Q19. Create an ArrayList and insert integers 1 through 10.
//		Display the ArrayList. Add all the even numbers up and
//		display the result. Add all the odd numbers up and display
//		the result. Remove the prime numbers from the ArrayList
//		and print out the remaining ArrayList.

public class Q19 {
	
	public static void main(String[] args) {
		List<Integer> num = new ArrayList<Integer>();
		
		//Populate
		for (int i = 1; i <= 10; i++) {
			num.add(i);
		}
		
		System.out.println("ArrayList: "+num.toString());
		
		//Even numbers
		int sum = 0;
		for (Integer ele : num) {
			if ((ele % 2) == 0) {
				sum += ele;
			}
		}
		System.out.println("Even sum: " + sum);
		
		//Odd numbers
		sum = 0;
		for (Integer ele : num) {
			if ((ele % 2) != 0) {
				sum += ele;
			}
		}
		System.out.println("Odd sum: " + sum);
		
		//remove primes
		for (int i = 0; i < num.size(); i++) {
			boolean prime = true;
			for (int j = 2; j < num.get(i); j++) {
				if((num.get(i) % j) == 0) {
					prime = false;
				}
			}
			//Remove the number if it is prime
			if (prime) {
				num.remove(i);
				i--;
			}
		}
		
		System.out.println("ArrayList without primes: " + num.toString());
	}

}
