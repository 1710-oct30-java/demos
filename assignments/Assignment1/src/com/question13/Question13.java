package com.question13;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Characters;

/*
 * displays triangle using loop
 * 0
 * 1 0
 * 1 0 1
 * 0 1 0 1
 * 
 */
public class Question13
{
	public static void main(String[] args)
	{
		String str = "";
		int rows = 4;
		boolean left = true;
		for (int i = 0; i < rows; i++)
		{
			if (str.isEmpty())
			{
				str = str + 0;
				System.out.println(str);
			}
			else if (left)
			{
				if (Character.getNumericValue(str.charAt(0)) == 0)
				{
					str = 1 + " " + str;
					System.out.println(str);
				}
				else
				{
					str = 0 + " " + str;
					System.out.println(str);
				}
				left = false;
			}
			else if (!left)
			{
				int length = str.length();
				if (Character.getNumericValue(str.charAt(length-1)) == 0)
				{
					str = str + " " +1;
					System.out.println(str);
				}
				else
				{
					str = str + " " +0;
					System.out.println(str);
				}
				left = true;
			}
		}
	}
}
