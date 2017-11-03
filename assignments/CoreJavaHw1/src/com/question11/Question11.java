package com.question11;

import com.question11b.OtherClass;

// Q11. Write a program that would access two float variables from a class that exists in another package.

public class Question11
{
	public static void main(String[] args)
	{
		System.out.println(OtherClass.getHeight());
		System.out.println(OtherClass.getWeight());
	}
}
