package com.revature.javacore.question13;

/*
	Display the triangle on the console as follows using any type of loop. Do NOT use
	a simple group of print statements to accomplish this.
	
	0
	1 0
	1 0 1
	0 1 0 1
 */

public class Question13
{

	static int[] arr = { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };

	public static void main(String[] args)
	{
		int rows = (arr.length / 2) - 1;
		int row = 1;
		
		// Iterate four times since there are 4 rows
        for (int i = rows; i > 0; i--)
        {
            if(row <= 2)
            {
            	// Print array elements
                for(int j = row; j < (row+row); j++)
                {
                	System.out.print(arr[j-1] + " ");
                }
            }
            
            else
            {
            	// Print array elements
                for(int j = row; j < (row+row); j++)
                {
                	System.out.print(arr[j] + " ");
                }
            }
            
            System.out.println();
 
            // Increment number of rows
            row++;
        }

	}

}
