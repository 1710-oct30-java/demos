package question01;

public class Q1 {

	/*
	 * Perform a bubble sort on the following array: [1, 0, 5, 6, 3, 2, 3, 7, 9, 8,
	 * 4]
	 */
	public static void main(String[] args) {
		int[] array = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		boolean switched = false;

		
		//Continue the loop until no numbers are switched.
		do {
			switched = false; 
			
			for (int i = 0; i < array.length - 1; i++) 
			{
				
				//If a number is greater than the number immediately following it, switch them.
				if (array[i] > array[i+1]) {
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					switched = true;					
				}
				
			}
		} while (switched);
		
		//Prints the result.
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		
		System.out.println();
	}
}
