package com.revature.question15.interfac;

public class CalculatorLauncher {
	public static void main(String[] args) {
		double a = 6;
		double b = 3;
		
		Q15Calculator calc = new Q15Calculator();

		System.out.println(calc.add(a, b));
		System.out.println(calc.subtract(a, b));
		System.out.println(calc.multiply(a, b));
		System.out.println(calc.divide(a, b));
	}
}
