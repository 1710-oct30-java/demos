package com.revature.control;

public class ControlStatements {
	public static void main(String[] args) {
		
		int i = 5;
		if(i > 10) {
			System.out.println("I is greater than 10");
		} else {
			System.out.println("I is less than or equal to 10");
		}
		
		while(i < 20) {
			System.out.println("I is now " + i++);
		}
		
		do {
			System.out.println(i);
		} while (i < 15);
		
		for(int j = 0; j < 10; j++) {
			System.out.println("this is loop number: " + (j+1));
		}
		
		
		switch (i) {
		case 20:
			System.out.println("case 20");
			break;
			
		case 15:
			System.out.println("case 15");
			break;
			
		default:
			System.out.println("default");
			break;
		}
		
	}
}
