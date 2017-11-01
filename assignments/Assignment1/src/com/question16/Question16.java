package com.question16;

import java.util.Arrays;
/*
 * counting the number of character in string entered through command line
 */
public class Question16
{
	public static void main(String[] args)
	{
		int length = 0;
		for (String str : args)
		{
			length = length + str.length();
		}
		System.out.println(Arrays.toString(args));
		System.out.println(length);
	}
}
