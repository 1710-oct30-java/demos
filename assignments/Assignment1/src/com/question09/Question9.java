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
		Question9PrimeList primeList = new Question9PrimeList();

		// creating an arrayList of number from 1-100
		for (int i = 1; i <= 100; i++)
		{
			numList.add(i);
		}

		primeList.checkPrime(numList, numList.size());

		for (int a : primeList.getPrimeList())
		{
			System.out.println(a);
		}

	}
}
