package q1;

public class Bubblesort {
	public static void main(String[] args) {
		int[] intArray = new int[11];
		intArray[0] = 1;
		intArray[1] = 0;
		intArray[2] = 5;
		intArray[3] = 6;
		intArray[4] = 3;
		intArray[5] = 2;
		intArray[6] = 3;
		intArray[7] = 7;
		intArray[8] = 9;
		intArray[9] = 8;
		intArray[10] = 4;
		
		for (int i = 0; i < intArray.length; i++) 
			for (int j = 0; j < intArray.length-1; j++){
			if (intArray[j] > intArray[j+1]) {
				int temp = intArray[j];
				intArray[j] = intArray[j+1];
				intArray[j+1] = temp;
			}
		}
		for (int i = 0; i< intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
	}
}
