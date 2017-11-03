package com.revature.question15;

/*
 * Write a program that defines an interface having the following methods: addition,
 * subtraction, multiplication, and division. Create a class that implements this interface and 
 * provides appropriapte functionality to carry out the required operations. Hard code two operands in a 
 * test class having a main method taht calls the implementing class
 */
public class Question15 implements Question15Interface{
	
	public Question15() {
		super();
	}

	@Override
	public int addition(int numOne, int numTwo) {
		return numOne + numTwo;
	}

	@Override
	public int subtraction(int numOne, int numTwo) {
		return numOne - numTwo;
	}

	@Override
	public int multiplication(int numOne, int numTwo) {
		return numOne * numTwo;
	}

	@Override
	public double division(int numOne, int numTwo) {
		int result = 0;
		try {
			result =  numOne/numTwo;
		}catch(ArithmeticException e){
			System.out.println("Division by 0");
		}
		return result;
		
	}
	
}
