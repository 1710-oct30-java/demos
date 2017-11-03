package question13;

/***
 * Display the triangle on the console as follows using any type of loop. Do NOT
 * use a simple group of print statements to accomplish this. 0 10 101 0101
 */

public class Q13 {

	public static void main(String[] args) {

		int row = 5;

		for (int i = 0; i < row; i++) {

			for (int j = 0; j <= i; j++) {

				System.out.print(Integer.toBinaryString(i));
			}
			System.out.println(""); 
		}

	}

}
