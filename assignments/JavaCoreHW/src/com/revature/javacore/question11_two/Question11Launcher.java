package com.revature.javacore.question11_two;

// Package imported to access the two float variables
import com.revature.javacore.question11_one.Question11;

/*
	Write a program that would access two float-variables from a class that exists in
	another package. Note, you will need to create two packages that demonstrate
	the solution.
 */
public class Question11Launcher
{
	public static void main(String[] args)
	{
		Question11 q = new Question11();
		
		System.out.println(q.getNum1());
		System.out.println(q.getNum2());
	}
}
