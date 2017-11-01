package q13;

public class Triangle {
	public static void main(String[] args) {
		// count variable to keep track of number
		int count = 0;

		// if the count is odd, print 1, if even print 0
		// do this for 4 lines, each line prints the number of times equal to its row
		// number
		
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				if (count % 2 == 1) {
					System.out.print(1 + " ");
					count++;
				} else if (count % 2 == 0) {
					System.out.print(0 + " ");
					count++;
				}

			}
			System.out.println(" ");
			System.out.println("");

		}
	}
}
