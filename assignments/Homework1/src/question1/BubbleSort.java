package question1;

//perform a bubble sort
public class BubbleSort {
	public static void main(String[] args) {
		//int[] testArray = {1, 0, 5, 6, 3, 2, 7, 9, 8, 4};
		int[] testArray = {11, 15, 12, 13, 14};
		
		
		for(int h = 0; h < testArray.length; h++) {
			for(int i = 0; i < testArray.length - 1; i++) {
				if(testArray[i] > testArray[i+1]) {
					int temp = testArray[i];
					testArray[i] = testArray[i+1];
					testArray[i+1] = temp;	
				}
			}	
		}
			
		for(int j = 0; j < testArray.length; j++) {
			System.out.println(testArray[j]);
		}
	}
}
