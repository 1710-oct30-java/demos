package com.question09;

import java.util.ArrayList;
import java.util.List;

public class Question9PrimeList
{
	private List<Integer> primeList = new ArrayList<>();
	
	public Question9PrimeList()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	
	public List<Integer> getPrimeList()
	{
		return primeList;
	}

	public void checkPrime(List<Integer> numList, int size)
	{
		for (int i = 0; i < size; i++)
		{
			// flag for prime number
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
	}
}
