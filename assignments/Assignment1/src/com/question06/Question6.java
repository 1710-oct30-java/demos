package com.question06;
/*
 * check odd/even without modulus
 */
public class Question6
{
	private static boolean isEven(int i)
	{
		int res = i/2;
		if (res*2 == i )
			return true;
	
		return false;
	}
	
	public static void main(String[] args)
	{
		System.out.println(isEven(2101));
	}
}
