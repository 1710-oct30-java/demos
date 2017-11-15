package com.revature.Q15;

public class BasicMathTest implements BasicMath {
	public static void main(String[] args) {
	
		BasicMath tester = new BasicMathTest();
		System.out.println(tester.addition(5,7));
		System.out.println(tester.subtraction(12,7));
		System.out.println(tester.multiplication(3,5));
		System.out.println(tester.division(4,2));
		System.out.println(tester.addition(tester.multiplication(2,3), tester.division(6, 3)));
	
	}
	
	public int addition(int x, int y) {
		return x+y;
	}

	@Override
	public int subtraction(int x, int y) {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public int multiplication(int x, int y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	@Override
	public int division(int x, int y) {
		// TODO Auto-generated method stub
		return x/y;
	}
}
