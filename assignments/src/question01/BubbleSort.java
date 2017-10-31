package question01;

import java.util.Arrays;

/**
 * Question 1: Perform a Bubble Sort on the following integer array:  {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4}
 * 
 * @author Mitch Goshorn
 */
public class BubbleSort {

	private static Integer[] toBeSorted = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};

	/**
	 * Conducts bubble sort on int arr
	 * @param arr - input arr
	 */
	public static void sort(Integer[] arr) {
		//Initialize sorted as false
		boolean sorted = false;
		while(!sorted) {
			//Set sorted to be true until we find something out of order
			sorted = true;
			for(int i = 1; i < arr.length; i++) {
				
				//if not in the right order
				if(arr[i-1] > arr[i]) {
					//sorted now false and swap values
					sorted = false;
					int temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
				}
			}
		}
	}

	/**
	 * Outputs array values
	 * @param arr - input array
	 */
	public static void outputArr(Integer[] arr) {
		Arrays.asList(arr).stream().forEach(v -> System.out.printf("%d ", v));
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("Initial state: ");
		outputArr(toBeSorted);
		
		System.out.println("\nSorted state: ");
		sort(toBeSorted);
		outputArr(toBeSorted);
	}
	
	
}
