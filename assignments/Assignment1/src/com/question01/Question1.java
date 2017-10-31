package com.question01;

import java.util.Arrays;


/*
 * bubble sort 1,0,5,6,3,2,3,7,9,8,4
 */
public class Question1
{
	public static void main(String[] args)
	{
		int numbers[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		for (int j = 0; j < numbers.length;j++)
			for (int i = 0; i < numbers.length-1; i++)
			{
				if (numbers[i] > numbers[i+1])
				{
					int temp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = temp;
				}
			}	
		System.out.println(Arrays.toString(numbers));
	}
}
