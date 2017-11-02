package question12;

/*
 * Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers
 * from the array. Use the enhanced FOR loop for printing out the numbers
 */
public class Question12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Generate array and fill with values 1-100
		int[] myArray = new int[101];
		for(int i = 1; i<myArray.length; i++) {
			myArray[i] = i;
		}
		
		//Enhanced FOR loop to print out numbers
		for(int i : myArray) {
			if(myArray[i]%2 == 0) {
				System.out.println(myArray[i]);
			}
		}
	}

}
