package com.revature.question15;

//Question15 test class
public class Test {

	public static void main(String[] args) {
		//Create an instance of the class(Question15) that implements the interface(Question15Interface)
		Question15 test = new Question15();
		
		//hard coded operands
		int firstNum = 10;
		int secondNum = 2;
		
		//perform operations on the operands
		System.out.println("addition: "+ test.addition(firstNum, secondNum));
		System.out.println("subtraction: " + test.subtraction(firstNum, secondNum));
		System.out.println("multiplication: " + test.multiplication(firstNum, secondNum));
		System.out.println("division: " + test.division(firstNum, secondNum));

		
	}

}
