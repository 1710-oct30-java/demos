package com.revature.question2;

public class Question2 {

	public void fib25() {
		int[] fibArray = new int[25];
		fibArray[0] = 0;
		fibArray[1] = 1;

		for (int i = 2; i < 25; i++) {
			fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
		}
		for (int i = 0; i < 25; i++) {
			System.out.print(fibArray[i] + " ");
		}
	}

	public static void main(String[] args) {
		Question2 fibArray25 = new Question2();
		
		System.out.println("Below is a printed fibonacci sequence up to 25 fibs!");
		fibArray25.fib25();
	}
}
