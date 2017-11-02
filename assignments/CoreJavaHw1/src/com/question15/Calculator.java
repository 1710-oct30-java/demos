package com.question15;

public class Calculator implements CalculatorI
{
	
	@Override
	public double add(double a, double b)
	{
		return a + b;
	}
	
	@Override
	public double subtract(double a, double b)
	{
		return a - b;
	}
	
	@Override
	public double multiply(double a, double b)
	{
		return a * b;
	}
	
	@Override
	public double divide(double a, double b)
	{
		return a / b;
	}
	
}
