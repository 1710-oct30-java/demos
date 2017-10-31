package com.question09;

/*
 * prime numbers from 1-100
 */
import java.util.ArrayList;
import java.util.List;

public class Question9
{
	public static void main(String[] args)
	{
		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> primeList = new ArrayList<Integer>();

		// creating an arrayList of number from 1-100
		for (int i = 1; i <= 100; i++)
		{
			numList.add(i);
		}

		// ready to iterate through numList 
		for (int i = 0; i < 100; i++)
		{
			//flag for prime number
			boolean isPrime = true;
			int temp = 0;
			// 0 and 1 are not prime
			if ((numList.get(i) == 0) || (numList.get(i) == 1))
				continue;
			else
			{
				// dividing all numbers from 2 to the current number
				for (int j = 2; j < numList.get(i); j++)
				{
					// found a divisible number 
					if (numList.get(i) % j == 0)
					{
						isPrime = false;
						break;
					}
				}
				// add the prime number in primeList
				if (isPrime)
				{
					primeList.add(numList.get(i));
				}
			}
		}

		for (int a : primeList)
		{
			System.out.println(a);
		}

	}
}
