package com.revature.homework.question15;

// Create a basic add, sub, mult, div interface and implement it

public class Question15test {
	public static void main(String[] args) {

		Question15 calculator = new Question15Impl();
		
		System.out.println("5.5 + 6 = "+calculator.addition(5.5, 6));
		System.out.println("5.5 - 6 = "+calculator.subtraction(5.5, 6));
		System.out.println("5.5 * 6 = "+calculator.multiplication(5.5, 6));
		System.out.println("5.5 / 6 = "+calculator.division(5.5, 6));

	}
}
