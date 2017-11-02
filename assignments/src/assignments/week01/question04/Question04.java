package assignments.week01.question04;

public class Question04 {
	public static void main(String[] args) {
		
		/*
		 * set test value
		 */
		int n = 5;
		
		System.out.println( factorial( n ) );
	}
	
	/**
	 * recursively calculate the factorial
	 * of an integer passed
	 * 
	 * @param int n
	 * @return int
	 */
	public static int factorial(int n)
	{
		/*
		 * recursion terminator condition
		 */
		if ( n == 0 ) {
			return 1;
		}
		
		/*
		 * recursive call
		 */
		return n * factorial( n - 1);
	}
}
