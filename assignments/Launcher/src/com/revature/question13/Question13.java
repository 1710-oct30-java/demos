package com.revature.question13;

public class Question13 {

	public static void main(String[] args) {
		
		// The first for loop represents the
		// four rows of the triangle
		for (int i=1; i <= 4;i++) {
			
			// looping until j<=i will ensure
			// that the amount of numbers in
			// each row will be equal to the
			// number of the row from top to
			// bottom (1 to 4)
			for(int j=1; j<=i;) {
				
				// This will result in an either
				// an even or odd number being
				// modded by 2, which would make
				// the result alternate between
				// being either 0 or 1
				int num = (i+j)%2;
				System.out.print(num + " ");
			}
			System.out.println("\n");
		}
	}

}
