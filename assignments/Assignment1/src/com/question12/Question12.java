package com.question12;

import java.util.Arrays;
/*
 * prints all even numbers using enhanced for loop
 */
public class Question12
{
	public static void main(String[] args)
	{
		int[] numList = new int[100];

		for (int i = 1; i <= 100; i++)
		{
			numList[i - 1] = i;
		}

		for (int i : numList)
		{
			if (i % 2 == 0)
				System.out.println(i);
		}
	}
}
