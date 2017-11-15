package com.revature.Q17;

import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Principal");
		int principal = sc.nextInt();
		
		System.out.println("Enter Rate");
		int rate = sc.nextInt();
		
		System.out.println("Enter Time");
		int time = sc.nextInt();
		
		System.out.println(rate*time*principal);
		
	}
}
