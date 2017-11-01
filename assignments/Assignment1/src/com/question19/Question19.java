package com.question19;

/*
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.question09.Question9PrimeList;

public class Question19
{
	public static void main(String[] args)
	{
		List<Integer> numList = new ArrayList<>();
		Question9PrimeList primeList = new Question9PrimeList();

		int resEven = 0;
		int resOdd = 0;
		for (int i = 1; i <= 10; i++)
		{
			numList.add(i);
		}
		System.out.println(numList);

		for (int num : numList)
		{
			if (num % 2 == 0)
				resEven = resEven + num;
			else
				resOdd = resOdd + num;
		}
		System.out.println("Sum of Even: " + resEven);
		System.out.println("Sum of Odd: " + resOdd);

		primeList.checkPrime(numList, numList.size());
		
		
		for (int num : primeList.getPrimeList())
		{
			for (int temp : new ArrayList<>(numList))
			{
				if (temp == num)
				{
					numList.remove(new Integer(temp));
				}
			}
		}
		System.out.println(numList);

	}
}
