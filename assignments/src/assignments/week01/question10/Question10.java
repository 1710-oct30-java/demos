package assignments.week01.question10;

public class Question10 {

	public static void main(String[] args) {
		/*
		 * generate a set of numbers to test
		 */
		int[][] pairs = {
			{  1,  5 },
			{ 10,  5 },
			{ 20, 21 },
			{ 55, 51 },
		};
		
		/*
		 * loop through test pairs and apply minimum function
		 */
		for(int[] pair: pairs ) {
			int a = pair[0];
			int b = pair[1];			
			int minimum = min(a, b);
			
			System.out.println( String.format("the minimum of pair { %2d,  %2d} is %2d", a, b, minimum ) );
		}
	}
	
	/**
	 * returns the minimum of two integers
	 * using a ternary operator
	 * 
	 * @param int a
	 * @param int b
	 * 
	 * @return int
	 */
	public static int min(int a, int b)
	{
		return ( a > b ) ? b : a;
	}
}
