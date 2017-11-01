package com.revature.javacore.question9;

import java.util.ArrayList;
import java.util.List;

/*
 	Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime
	numbers to the console.
 */

public class Question9 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= 100; i++)
		{
			list.add(i);
		}
		
		displayPrimeNumbers(list);
		System.out.println(isPrime(1));
	}
	
	// Displays all prime numbers from the ArrayList
	public static void displayPrimeNumbers(List<Integer> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			// Print number to screen if it is a prime number
			if(isPrime(list.get(i)))
			{
				System.out.print(list.get(i) + " ");
			}
		}
	}
	
	// Returns true if number is prime
	public static boolean isPrime(int num)
	{
		// Initially, return false if number is equal to one
		if(num == 1)
		{
			return false;
		}
		
		for(int i = 2; i <= num/2; i++)
		{
			// If number is divisible by current number, number is not prime
			if(num % i == 0)
			{
				return false;
			}
		}
		return true;
	}

}
