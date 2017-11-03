package com.revature.homework.question1;
// Perform a bubble sort

public class Question1 {
	public static void main(String[] args) {
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.println("array before bubble sort ");
		
		for (int i=0;i<array.length;i++) {
			System.out.print(array[i]+ ", ");
		}
		System.out.println();
		System.out.println("array after bubble sort ");
		array = bubbleSort(array);
		for (int i=0;i<array.length;i++) {
			System.out.print(array[i]+ ", ");
		}
	}
	
	public static int[] bubbleSort(int[] arr) {
		// bubble sort
		int n = arr.length;
		int temp = 0;
		
		for (int i=0; i<n; i++) {
			for (int j=1; j<(n-i); j++) {
				if (arr[j-1]>arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

}
