package com.revature.question19;

import java.util.ArrayList;
import java.util.List;

/*
 * Create an ArrayList and insert integers 1 through 10. Display the 
 * ArrayList. Add all the even numbers up and display the result.
 * Add all the odd numbers up and display the result. Remove the prime numbers
 * from the ArrayList and print out the remaining ArrayList
 */

public class Question19 {

	public static void main(String[] args) {
		//create array list
		List<Integer> intList = new ArrayList<>();
		
		//insert 1-10 to the list
		for (int i = 1; i <= 10; i++) {
			intList.add(i);
		}
		
		//Display the list
		System.out.println("original list");
		for(Integer num: intList) {
			System.out.println(num);
		}
		
		//add all the even numbers and display the result
		int evenSum = 0;
		for(Integer num: intList) {
			if(num % 2 == 0) {
				evenSum += num;
			}
		}
		System.out.println("Even Sum is: " + evenSum);
		
		//add all the odd numbers and display  the result
		int oddSum = 0;
		for(Integer num: intList) {
			if(!((num % 2) == 0)) {
				oddSum += num;
			}
		}
		System.out.println("Odd Sum is: " + oddSum);
		
		//Remove the prime numbers from the ArrayList and print out the remaining ArrayList
		for(int i = 0; i < intList.size(); i++) {
			if(prime(intList.get(i))) {
				System.out.println("prime: " + intList.get(i));
				intList.remove(new Integer(intList.get(i)));
				i = i - 1;	//decrease the index because the elements were moved down when the prime number was removed
			}
		}
		
		System.out.println("remaining numbers in the list: ");
		for(Integer num: intList) {
			System.out.println(num);
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
