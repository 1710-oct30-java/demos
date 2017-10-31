package com.revature.javacore.question1;

/*
 * Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
 * */

public class Question1
{

	public static void main(String[] args)
	{
		int[] array = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		// print array before bubble sort
		System.out.println("Array before sort: ");
		display(array);

		// bubble sort
		bubbleSort(array);
		
		// print array before bubble sort
		System.out.println("Array before sort: ");
		display(array);
	}

	// Sort an array
	public static void bubbleSort(int arr[])
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i+1; j < arr.length; j++)
			{
				System.out.println(arr[i] + "," + arr[j]);
//				if(i < j)
//				{
//					int tmp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = tmp;
//				}
			}
		}
	}

	// Prints array values
	public static void display(int arr[])
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (i == arr.length - 1)
			{
				System.out.print(arr[i] + "\n");
			}

			else
			{
				System.out.print(arr[i] + ", ");
			}
		}
	}

}
