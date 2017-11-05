package com.revature.question13;

public class Question13 {
	public static void main(String[] args) {

		int count1 = 1;
		int count2 = 1;

		for (int i = 0; i < 10; i++) {
			if (count1 == 0) {
				System.out.print("\n");
				count2++;
				count1 = count2;
			}
			count1--;
			System.out.print(i % 2);
		}
	}
}