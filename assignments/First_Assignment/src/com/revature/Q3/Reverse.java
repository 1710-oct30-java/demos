package com.revature.Q3;

import java.util.Scanner;

public class Reverse {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.nextLine();
		
		String d = "";
		
		
		for(int x = 0; x < s.length(); x++) {
			d = d + s.charAt(s.length()-1 - x);
			}
		
		System.out.println(d);
		
		scanner.close();
	}
}
