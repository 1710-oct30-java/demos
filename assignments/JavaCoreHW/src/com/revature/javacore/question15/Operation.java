package com.revature.javacore.question15;

public class Operation implements Operator
{

	// Add
	@Override
	public double add(double num1, double num2)
	{
		double result = 0;

		try
		{
			result = num1 + num2;
			System.out.println(num1 + " + " + num2 + " = " + result);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	// Subtract
	@Override
	public double subtract(double num1, double num2)
	{
		double result = 0;

		try
		{
			result = num1 - num2;
			System.out.println(num1 + " - " + num2 + " = " + result);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	// Multiply
	@Override
	public double multiply(double num1, double num2)
	{
		double result = 0;

		try
		{
			result = num1 * num2;
			System.out.println(num1 + " * " + num2 + " = " + result);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	// Divide
	public double divide(double num1, double num2)
	{
		double result = 0;

		try
		{
			// Prevent division by zero
			if (num2 == 0)
			{
				System.out.print(num1 + " / " + num2 + " = ");
				System.out.println("Error!! Cannot divide by zero!");
			} else
			{
				result = num1 / num2;
				System.out.println(num1 + " / " + num2 + " = " + result);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

}
