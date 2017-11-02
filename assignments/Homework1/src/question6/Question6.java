package question6;

/*
 * Write a program to determine if an integer is even without using the modulus operator (%)
 */

public class Question6 {
	
	public static boolean isEven(int n) {
		if((n/2) * 2 == n) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isEven(3));
		System.out.println(isEven(4));
		
	}

}
