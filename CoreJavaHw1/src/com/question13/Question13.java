package com.question13;

/* Display the triangle on the console as follows using any type of loop.
 * Do NOT use a simple group of print statements to accomplish this...
 * 0
 * 1 0
 * 1 0 1
 * 0 1 0 1
*/

public class Question13
{
	public static void main(String[] args)
	{
		StringBuilder sb = new StringBuilder();
		String toAdd;
		
		for (int i = 0; i < 4; i++)
		{
			// Every third loop adds a 0
			toAdd = i % 3 == 0 ? "0 " : "1 ";
			
			// Switches every loop between beginning and end of sb
			if (i % 2 == 0)
				sb.insert(sb.length(), toAdd);
			else
				sb.insert(0, toAdd);
			
			System.out.println(sb);
		}
	}
}