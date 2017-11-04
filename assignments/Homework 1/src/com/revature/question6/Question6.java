package com.revature.question6;

import java.util.Scanner;

public class Question6 {
	public void checkEven(int isThisIntEven) {
		
		int check = isThisIntEven/2;
		int check2 = check * 2;
		
		if (check2 == isThisIntEven)
			System.out.println(isThisIntEven + " Is an even integer!");
		else 
			System.out.println(isThisIntEven + " Is NOT an even integer");
	}
	
	public static void main(String[] args) {
		
		System.out.println("Please input an integer N");
		Scanner inputN = new Scanner(System.in);
		int integer = inputN.nextInt();
		Question6 checkEven = new Question6();
		checkEven.checkEven(integer);
		inputN.close();
	}

}
