package com.revature.question13;

public class Question13 {

	public static void main(String[] args) {
		for (int i=1; i <= 4;i++) {
			for(int j=1; j<=i;) {
				int num = (i+j)%2;
				System.out.print(num + " ");
			}
			System.out.println("\n");
		}
	}

}
