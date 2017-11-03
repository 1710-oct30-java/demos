package question06;

/**
 * Question 6: Write a program to determine if an integer is even without using the modulus operator (%)
 * 
 * Solution: Only the final in the ones position is important, so truncate the value to the 
 * final value by converting it to a string and getting the substring, then convert back to an integer
 * Then use a switch statement to get a condition for the 5 remaining possible even values, 
 * and default to false for odd values.
 * @author BlueT
 *
 */
public class IsEven {
	public static boolean isEven(int i) {
		
		//get integer in the 'ones' position
		String string = String.valueOf(i);
		string = string.substring(string.length()-1);
		int finalValue = Integer.valueOf(string);
		
		switch(finalValue) {
			case 0:  return true;
			case 2:  return true;
			case 4:  return true;
			case 6:  return true;
			case 8:  return true;
			default: return false;
		}
	}
	
	public static void main(String[] args) {
		int testCase1 = 10;
		int testCase2 = 5;
		int testCase3 = 10004427;
		
		System.out.printf("%8s is even: %b%n", testCase1, isEven(testCase1));
		System.out.printf("%8s is even: %b%n", testCase2, isEven(testCase2));
		System.out.printf("%8s is even: %b%n", testCase3, isEven(testCase3));
	}
	
	
}
