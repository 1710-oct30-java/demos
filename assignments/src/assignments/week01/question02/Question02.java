package assignments.week01.question02;

import java.util.Arrays;

public class Question02 
{
	public static void main(String[] args)
	{
		/*
		 * generate the Fibonacci sequence
		 * of numbers that occur sequentially
		 * between the two values
		 */
		int[] sequence = getSequence(0, 25);
		
		display( sequence );
		
	}
	
	/**
	 * use the FibonacciSequencer to generate an array
	 * of integers in the Fibonacci sequence between the
	 * numbers given
	 * 
	 * @param int start
	 * @param int digits
	 * 
	 * @return int[]
	 */
	public static int[] getSequence(int start, int digits)
	{
		int[] output = new int[digits];
		FibonacciSequencer f = new FibonacciSequencer();
		
		/*
		 * increment the Fibonacci sequence until you hit the starting number
		 */
		while( f.getCurrent() < start )  {
			f.increment();
		}
		
		/*
		 * begin storing the output of the Fibonacci sequencer
		 * for the targeted digits in the output buffer
		 * until the targeted number of digits are acquired
		 */
		for( int i = 0; i < digits; i++ ) {
			output[i] = f.getCurrent();
			f.increment();
		}
		
		return output;
	}
	
	/**
	 * display an array of integers to the console
	 * 
	 * @param int[] sequence
	 */
	public static void display(int[] sequence )
	{
		System.out.println( Arrays.toString( sequence ) );
	}
	
	

	
	
	
}
