package question10;

/*
 * Find the minimum of two numbers using ternary operators
 */

public class Question10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10;
		int j = 9;
		
		//Ternary operator of form (conditional statement) ? [if true]:[if false]
		int min = (i < j) ? i:j;
		
		System.out.println(min);
	}

}
