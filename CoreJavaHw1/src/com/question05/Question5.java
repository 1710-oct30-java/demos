package com.question05;

/*	Q5. Write a substring method that accepts a string str and an integer idx
	and returns the substring contained between 0 and idx-1 inclusive. Do NOT use
	any of the existing substring methods in the String, StringBuilder, or
	StringBuffer APIs.
*/

public class Question5
{
	public static void main(String[] args)
	{
		String myString = substring("I love eating ice cream", 17);
		System.out.println(myString);
	}
	
	static String substring(String str, int idx)
	{
		String newStr = "";
		
		// Concatenate to the new string
		for (int i = 0; i < idx; i++)
			newStr += str.charAt(i);
		
		return newStr;
	}
}
