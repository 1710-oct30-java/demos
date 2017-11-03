package com.revature.question13;

/* 
 * Display the triangle on the console using any type of loop
 * DONT use group of print statements
 * 0
 * 1 0
 * 1 0 1
 * 1 0 1
 * 0 1 0 1
 */
public class Question13 {

	public static void main(String[] args) {

		String s = "0110";
		boolean front = false;
		String out = "";

		for (int i = 0; i < 4; i++) {
			if (front == false) {
				if (i == 0) { // Use this logic specifically for 0 so that I do not add spaces to string
					out = out + s.charAt(i);
					front = true;
					System.out.println(out);

				} else { // Logic for every other number that trigger is false
					out = out + " " + s.charAt(i);
					front = true;
					System.out.println(out);
				}
			} else { // Logic for numbers when trigger is true
				out = s.charAt(i) + " " + out;
				front = false;
				System.out.println(out);

			}
		}

	}

}
