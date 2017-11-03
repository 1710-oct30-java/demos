package com.revature.question13;

/*
 * Display the triangle on the console as follows using
 * any type of loop. Do NOT use a simple group of print statements
 * to accomplish this
 */
public class Question13 {

	public static void main(String[] args) {
		/*
		 * 0            1 + 1 = 2 even % 2 = 0
		 * 1 0 			2 + 1 = 3 % 2 = 1, 
		 * 1 0 1 
		 * 0 1 0 1
		 */
		int k = 1; //variable to print either 0 or 1 if odd print 0, else print 1
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				if ((k) % 2 == 0) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
				k++;
			}
			System.out.println();
		}
	}
}
