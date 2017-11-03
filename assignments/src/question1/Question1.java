package question1;

import java.util.Arrays;

public class Question1
{
	// Perform a bubble sort on the integer array [1,0,5,6,3,2,3,7,9,8,4].
	public static void main(String[] args)
	{
		// Initialize the starting array.
		int[] ary = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		// Initialize variable for tracking if a swap has occurred.
		boolean swap = false;
		
		// Initialize variable for tracking number of passes.
		int x = 0;
		
		// Print initial state of array to the console.
		System.out.println("The starting array is " + Arrays.toString(ary) + ".");
		
		// Perform bubble sort on the array while outputting each state change for the array. Once sorting is complete, a message will
		// be output saying so.
		do
		{
			swap = false;
			System.out.println("\nStarting pass " + (x+1) + ".");
			for(int y = 0; y < ary.length-x-1; y++)
			{
				if(ary[y] > ary[y+1])
				{
					int tmp = ary[y+1];
					ary[y+1] = ary[y];
					ary[y] = tmp;
					swap = true;
					System.out.println("The array is now " + Arrays.toString(ary) + ".");
				}
			}
			x++;
			if(!swap)
			{
				System.out.println("No swaps detected. Sorting is complete.");
			}
		}while(swap);
	}
}