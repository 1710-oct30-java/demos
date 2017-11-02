package question13;

/*
 * Display the triangle on the console as follows using any type of loop. Do NOT use a simple group of print statements to accomplish this.
 * 0
 * 10
 * 101
 * 0101
 */
public class Question13 {
	public static void main(String[] args) {
		// This will be the number we will print out
		int number = 0;
		// this will be our "each line" loop
		for (int i = 1; i < 5; i++) {
			// this will be our printing loop
			for (int j = 0; j < i; j++) {
				System.out.print(number);
				// after the number is printed it will need to be switched to the next number
				// 0 + 1 % 2 == 1
				// 1 + 1 % 2 == 0
				number = (number + 1) % 2;
			}
			// go to the next line
			System.out.print('\n');
		}
	}
}
