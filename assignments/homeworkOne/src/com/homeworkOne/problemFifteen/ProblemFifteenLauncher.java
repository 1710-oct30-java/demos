package com.homeworkOne.problemFifteen;

public class ProblemFifteenLauncher extends ProblemFifteen {
	
	public static void main(String[] args) {
		ProblemFifteen operations = new ProblemFifteen();
		
		System.out.println(operations.addition(1, 2));
		System.out.println(operations.subtraction(4, 1));
		System.out.println(operations.multiplication(6, 4));
		System.out.println(operations.division(8, 2));
		System.out.println(operations.division(4, 0));
	}

}
