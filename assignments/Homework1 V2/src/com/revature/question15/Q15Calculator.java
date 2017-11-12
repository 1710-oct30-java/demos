package com.revature.question15;

public class Q15Calculator implements Q15Interface {

	@Override
	public double multiply(double a, double b) {
		return a*b;
	}

	@Override
	public double add(double a, double b) {
		return a+b;
	}

	@Override
	public double subtract(double a, double b) {
		return a-b;
	}

	@Override
	public double divide(double a, double b) {
		return a/b;
	}
}
