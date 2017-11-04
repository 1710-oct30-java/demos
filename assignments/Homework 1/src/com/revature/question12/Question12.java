package com.revature.question12;

public class Question12 {
	public static void main(String[] args) {
		int[] array100 = new int[100];
		for (int i = 0; i < 100; i++) {
			array100[i] = i + 1;
		}

		for (int john : array100) {
			if (john % 2 == 0) {
				System.out.println(john);
			}
		}
	}
}
