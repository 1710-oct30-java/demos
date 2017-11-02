package com.revature.javacore.question19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.javacore.question9.Question9;

/*
	Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all
	the even numbers up and display the result. Add all the odd numbers up and display the
	result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 */

public class Question19
{
	private static List<Integer> list = new ArrayList<Integer>();
	private static int evenSum = 0;
	private static int oddSum = 0;

	public static void main(String[] args)
	{
		// Insert integers 1 through 10 to the list
		// Add all even and odd numbers
		for (int i = 1; i <= 10; i++)
		{
			list.add(i);
			if (isEven(i))
			{
				evenSum += i;
			} else
			{
				oddSum += i;
			}
		}

		// Display the items on the list
		displayList();
		
		// Display sum of even and odd numbers
		System.out.println("Even sum: " + evenSum);
		System.out.println("Odd  sum: " + oddSum);
		
		// Remove all prime numbers from the list
		removePrimeNumbers();
		
		// Display the list after removing prime numbers
		displayList();

	}

	// Display the items on the list
	public static void displayList()
	{
		for (Integer i : list)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}

	// Checks if number is even
	public static boolean isEven(int n)
	{
		if (n % 2 == 0)
		{
			return true;
		}
		return false;
	}
	
	// Methods uses Iterator to remove prime numbers from the list
	public static void removePrimeNumbers()
	{
		try
		{
			Iterator<Integer> itr = list.iterator();
			
			while(itr.hasNext())
			{
				int i = itr.next();
				
				// Use method created in Question9 class to check if number is prime
				if(Question9.isPrime(i))
				{
					itr.remove();
				}
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
