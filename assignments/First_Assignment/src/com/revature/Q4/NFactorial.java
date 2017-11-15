package com.revature.Q4;

import java.util.Scanner;

public class NFactorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = 1;
		
		for(int i = 1; i <= x; i++) {
			y = y * i;
		}
		
		System.out.println(y);
	}
}
