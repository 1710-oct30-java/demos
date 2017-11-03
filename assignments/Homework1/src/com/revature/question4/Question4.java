package com.revature.question4;
import java.util.*;

/*
 * Write a program to compute N factorial
 */

public class Question4 {
	
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		System.out.println("Enter int for n:");
		int n = key.nextInt();
		int temp = 1;
		
		for (int i = n; i > 0; i--) {
			temp *= i;
		}
		
		System.out.println(temp);
		
	}

}
