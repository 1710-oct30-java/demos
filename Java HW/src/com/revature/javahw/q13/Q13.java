// Christopher Youngblood
// 10/31/2017
// Revature Java Course
// Homework 1 - Question 13

package com.revature.javahw.q13;

// Q13. Display the trinangle on the console as follows using any
//      type of loop. Do NOT use a simple group of print statements
//      to accomplish this.
//      0
//		1 0
//		1 0 1
//		0 1 0 1

public class Q13 {
	public static void main(String[] args) {
		//For memory between levels of the triangle
		int x = 1;
		//Depth
		int y = 4;
		
		//line iteration
		for (int i = 1; i <= y; i++) {
			
			//Creates an alternating system of 1s and 0s
			//for a length equal to the depth
			for (int j = 0; j < i; j++) {
				x -= 1;
				x *= -1;
				System.out.print(x + " ");
			}
			
			//On to the next line
			System.out.println();
		}
	}
}
