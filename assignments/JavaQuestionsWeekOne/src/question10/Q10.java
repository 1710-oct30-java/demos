package question10;

public class Q10 {
	
	//Find the minimum of two numbers using ternary operators.

	public static void main(String[] args) {
		int a = 7;
		int b = 5;
		
		System.out.println(minimum(a,b));
	}
	
	public static int minimum(int a, int b) {
		//return (condition) ? condition == true : condition == false;
		return a < b ? a : b;
	}

}
