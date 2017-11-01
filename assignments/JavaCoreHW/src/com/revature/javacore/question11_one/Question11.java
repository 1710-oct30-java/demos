package com.revature.javacore.question11_one;

/*
	Write a program that would access two float-variables from a class that exists in
	another package. Note, you will need to create two packages that demonstrate
	the solution.
 */

public class Question11
{
	public float num1 = 5;
	public float num2 = 2;
	
	public float getNum1()
	{
		return num1;
	}
	public void setNum1(float num1)
	{
		this.num1 = num1;
	}
	public float getNum2()
	{
		return num2;
	}
	public void setNum2(float num2)
	{
		this.num2 = num2;
	}
}
