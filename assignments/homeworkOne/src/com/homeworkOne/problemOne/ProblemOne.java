package com.homeworkOne.problemOne;

public class ProblemOne {
	//Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
	public static void main(String[] args)
	{
	//Init variables
	int bubbleSort[] = {1,0,5,6,3,2,7,9,8,4};
	int temp;
	
	//double loop to perform bubble sort
		for(int i = 0; i<bubbleSort.length; i++)
		{
			for(int j = 0; j<bubbleSort.length-1; j++)
			{
				if(bubbleSort[i] > bubbleSort[j])
				{   //swap elements
					temp = bubbleSort[i];
					bubbleSort[i] = bubbleSort[j];
					bubbleSort[j] = temp;
				}
			}	
		}
		//print results
		for(int i=0 ; i<bubbleSort.length;i++)
		{
			System.out.print(bubbleSort[i]+ " ");
		}
	
	}

}
