package com.homeworkOne.problemTen;

public class ProblemTen 
{
	//Find the minimum of two numbers using ternary operators
	public static void main(String[] args) 
	{
		ternary(10,20);
		ternary(234,487);
		ternary(8372,578);
		ternary(1003,230);
		ternary(24334,4547);
		ternary(822,15478);
	}
	
	//Method to check numbers
	public static void ternary(int num1, int num2)
	{
		System.out.println(num1<num2?(num1+ " is less than " + num2):(num1+ " is greater than " + num2));
	}

}
