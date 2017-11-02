package question1;

/*
 * Kyle Settles
 * Perform a bubble sort on the following integer array:
 * 1,0,5,6,3,2,3,7,9,8,4
 */

public class Question1 {
	
	public static int[] myArray = {1,0,5,6,3,2,3,7,9,8,4};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Perform bubble sort
		for (int i = 0; i < (myArray.length-1); i++) {
			for (int j = 0; j < (myArray.length-i-1); j++) {
				if( myArray[j] >= myArray[j+1]) {
					int temp = myArray[j];
					myArray[j] = myArray[j+1];
					myArray[j+1] = temp;
				}
			}
		}
		
		// Print sorted array
		for( int i = 0; i< myArray.length; i++) {
			System.out.println(myArray[i]);
		}
	}
}
