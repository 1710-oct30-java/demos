package com.question05;

/*
 * substring method accepts a string and idx, 
 * return substring from 0 to idx-1 inclusively
 */
public class Question5
{
	public static String mySub(String str, int idx)
	{
		String res = new String();

		for (int i = 0; i < idx; i++)
			res = res + str.charAt(i);
		return res;
	}
	
	public static void main(String[] args)
	{
		System.out.println(mySub("Hello World", 3));
	}
}
