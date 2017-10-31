package com.question04;
/*
 * N Factorial
 */
public class Question4
{
	public static void main(String[] args)
	{
		int res = 1;
		int num = 3;
		
		for (int i = 1; i <= num; i++)
		{
			res = res*i;
		}
		System.out.println(res);
	}
}
