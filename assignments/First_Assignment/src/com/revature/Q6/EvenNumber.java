package com.revature.Q6;

import java.util.Scanner;

public class EvenNumber {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();		
		int y = 0;
		int z = 0;
		
		y = x/2;
		z = y*2;
		
		if(z==x) {
			System.out.println("Number is even");
		}
		else {
			System.out.println("Number is odd");
		}
		
		
		sc.close();
	}
}
