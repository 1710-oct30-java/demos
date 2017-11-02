package question13;

/*
 * Kyle Settles
 * Display the triangle on the console as follows using any type of loop. Do NOT use a 
 * simple group of print statements to accomplish this.
 * 0
 * 10
 * 101
 * 0101
 */

public class Question13 {

	public static void main(String[] args) {

		// outer loop used to determine which line is being created
		for(int i = 1; i <= 4; i++) {
			
			// loop used to determine how many characters in each line
			for(int j = 1; j <= i; j++) {
				
				// if line is 2 or 3 reverse the output to match the question
				if(i == 2 ||i == 3) {
					if(j % 2 == 1) {
						System.out.print("1");
					}
					else {
						System.out.print("0");
					}
				}
				// if line is 1 or 4, odd = "0" and even = "1"
				else {
				// if it is 0 or odd, print a zero
					if(j%2 == 1) {
						System.out.print("0");
					}
				// if it is even print a 1
					else {
						System.out.print("1");
					}
				}
			}
			// move to next line
			System.out.println();
		}
	}

}
