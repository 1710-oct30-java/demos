/*
 * Question 13
 * Display the triangle on the console as follows using any type of loop. Do NOT use a simple group of print statements to accomplish this.
 * 0
 * 10
 * 010
 * 1010
 * By: Brice Petty
 * Credit To:
 */
package com.revature.question13;

public class PrintBinaryTriangle {
	public static void printTheTriangle() {
		for (int i = 4; i > 0; i--) {			
			for (int j = 4; j >= i; j--) {
				System.out.print((j + i) % 2);
			}
			System.out.println("");
		}
	} //Figured out how to do it with a pair of nested forLoops :)

	public static void main(String[] args) {
		printTheTriangle();
	}
}