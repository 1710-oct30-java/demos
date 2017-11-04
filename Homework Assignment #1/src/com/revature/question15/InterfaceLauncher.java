package com.revature.question15;

public class InterfaceLauncher {

	public static void main (String[] args) {
		
		question15 obj = new question15();
		
		int i = 50;
		int j = 250;
		
		System.out.println("50 + 250 is equal to: " + obj.add(i, j));
		System.out.println("50 - 250 is equal to " + obj.subtract(i, j));
		System.out.println("50 * 250 is equal to " + obj.multiplication(i, j));
		System.out.println("50 / 250 is equal to " + obj.division(i, j));
		
		
	}

}
