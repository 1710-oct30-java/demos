package com.revature.javacore.question13;

/*
	Display the triangle on the console as follows using any type of loop. Do NOT use
	a simple group of print statements to accomplish this.
	
	0				        0
	1 0			--->      1   0
	1 0 1			    1   0   1
	0 1 0 1			  0   1   0   1
 */
public class Question13
{

	static int[] arr = { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };

	public static void main(String[] args)
	{

		for (int i = 1; i <= arr.length; i++) {

		    for (int j = 1; j < i; j++) {
		        System.out.printf(" ");
		    } 
		    for (int j = i; j <= 6; j++) {              
		    	System.out.printf("%2d", arr[(j)]);
		    }

		}

	}

}
