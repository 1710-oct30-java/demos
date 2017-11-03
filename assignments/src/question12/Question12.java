package question12;

public class Question12
{
	// Write a program to store numbers 1 to 100 in an array.
	// Print out all the even numbers from the array. Use the
	// enhanced FOR loop for printing out the numbers.
	public static void main(String[] args)
	{
		// Initialize array for storing numbers.
		int[] ary = new int[100];
		
		// Populate array with numbers.
		for(int a = 0; a < 100; a++)
		{
			ary[a] = a+1;
		}
		
		// Iterate through the array and print the even numbers.
		for(int n : ary)
		{
			if((n%2) == 0)
			{
				System.out.println(n);
			}
		}
	}
}