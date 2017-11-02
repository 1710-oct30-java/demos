package questionThirteen;

public class Q13 {

	// Display the triangle on the console as follows using any type of loop. Do NOT
	// use a simple group of print statements to accomplish this.

	public static void main(String[] args) {
		//Keeps track of the odd/even for printing 1 or 0.
		int count = 0;
		
		//Iterate through every row.
		for (int i = 0; i < 8; i++) {
			//Iterate through this specific row.
			for (int j = 0; j < i; j++) {
				//If count is even, print 0. Otherwise, print 1.
				if ((count)%2 == 0) System.out.print(0);
				else System.out.print(1);
				
				//Print a space and increment the count.
				System.out.print(" ");
				count++;
			}
			//Skip to the next line.
			System.out.println();
		}
	}

}
