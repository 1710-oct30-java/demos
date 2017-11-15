package com.question15;

/* Q15. Write a program that defines an interface having the following methods: addition, subtraction,
 * multiplication, and division. Create a class that implements this interface and provides appropriate
 * functionality to carry out the required operations. Hard code two operands in a test class having a
 * main method that calls the implementing class.
*/

public class Question15
{
	public static void main(String[] args)
	{
		double op1 = 15;
		double op2 = 10;
		
		Calculator myCalc = new Calculator();
		
		// Calculate values and print
		double sum = myCalc.add(op1, op2);
		System.out.println(op1 + " + " + op2 + " = " + sum);
		
		double diff = myCalc.subtract(op1, op2);
		System.out.println(op1 + " - " + op2 + " = " + diff);
		
		double product = myCalc.multiply(op1, op2);
		System.out.println(op1 + " * " + op2 + " = " + product);
		
		double quotient = myCalc.divide(op1, op2);
		System.out.println(op1 + " / " + op2 + " = " + quotient);
	}
}