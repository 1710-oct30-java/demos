package com.question09;

import java.util.ArrayList;

// Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.

public class Question9
{
	public static void main(String[] args)
	{
		// Test
		// for (int i = 1; i < 50; i++)
		// {
		// if (isPrime(i))
		// System.out.println(i + " is a prime number.");
		// }
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		for (int i = 0; i < 100; i++)
			ints.add(i + 1);
		
		System.out.println(ints.toString());
		
		for (int i : ints)
		{
			if (isPrime(i))
				System.out.println(i);
		}
	}
	
	public static boolean isPrime(int val)
	{
		// 2 is the first prime
		if (val < 2)
			return false;
		
		boolean isP = true;
		
		// Check if val is divisible by any number other than 1 and itself
		for (int i = 2; i < val; i++)
		{
			if (val % i == 0)
			{
				isP = false;
				break;
			}
		}
		return isP;
	}
}
