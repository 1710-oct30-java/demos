package assignments.week01.question01;

import java.util.Arrays;

public class Question01 {
	
	public static void main (String[] args)
	{
		/*
		 * declaring the data set
		 */
		int[] data = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		System.out.println("before sort: " + display( data ) );
		
		/*
		 * sort data
		 */
		sort( data );
		
		System.out.println("after sort: " + display( data ) );
		
	}
	
	/**
	 * performs the bubble sort algorithm on an
	 * array of integers
	 *  
	 * @param int[] data
	 */
	public static void sort(int[] data)
	{
		int upperBound = data.length - 1; // the last digit has no nextNumber
		Integer currentNumber = 0;
		Integer nextNumber = 0;
		Boolean swapped; // true if a swap occurs
		
		do {
			/*
			 * reset the flag for each iteration to prevent
			 * looping infinitely through the array
			 */
			swapped = false; 
			
			for(int i = 0; i < upperBound; i++ ) {
				currentNumber = data[i];
				nextNumber = data[ i + 1];
				
				/*
				 * if this number is greater than the next,
				 * swap positions with the next number
				 */
				if ( currentNumber > nextNumber ) {
					swapped = true;
					data[i] = nextNumber;
					data[i + 1] = currentNumber;
				} 
			}
			
//			System.out.println( display(data ) );
			
		} while ( swapped == true );
	}
	
	/**
	 * displays an array of integers to the console
	 * 
	 * @param int[] data
	 * @return String
	 */
	public static String display(int[] data )
	{
		return Arrays.toString( data );
	}
	
	

}
