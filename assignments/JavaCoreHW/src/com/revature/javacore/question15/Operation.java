package com.revature.javacore.question15;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Operation implements Operator
{
	
	//NumberFormat formatter = new DecimalFormat("#0.00");

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

	public double divide(double num1, double num2)
	{
		double result = 0;

		try
		{
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
