package com.question02;

import java.util.*;

/*
 * first 25 fibonacci numbers starting from 0
 */
public class Question2
{

	
	public static void main(String[] args)
	{
		List<Integer> fibList = new ArrayList<Integer>();
		fibList.add(0);
		fibList.add(1);
		int count = 25;
		
		for (int i = 2; i < count; i++)
		{
			int temp = fibList.get(i-1) + fibList.get(i-2);
			fibList.add(temp);
		}
		fibList.forEach(System.out::println);
	}
}
