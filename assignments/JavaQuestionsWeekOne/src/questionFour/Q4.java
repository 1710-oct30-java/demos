package questionFour;

public class Q4 {
	
	//Write a program to compute N factorial.

	public static void main(String[] args) {
		System.out.println(factorial(4));

	}
	
	public static int factorial(int i) {
		int result = 1;
		
		for (int j = 1; j <= i; j++) {
			result *= j;
		}
		
		return result;
		
	}

}
