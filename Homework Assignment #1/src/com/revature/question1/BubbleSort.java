package com.revature.question1;
//Programmer: Robert L Choboy
//Revature Week 1 Homework Assignment 
//This program will perform a bubble sort of an array

public class BubbleSort {

	public static void main (String[]  args)
		{
		int[] ary = {1,0,5,6,3,2,3,7,9,8,4};
		//perform the bubble sort for this specific set of numbers
		    
		  for (int a=0; a < ary.length - 1; a++)
		   {
			   for (int val=0; val<ary.length - a - 1; val++)
			   {
				   if (ary[val]>ary[val + 1])
				   {
					   //swapval is the value that is being switched
					   int temp = ary[val];
					   ary[val] = ary [val + 1];
					   ary[val + 1] = temp; }
			   }	
		   } 
		   //Print The Bubble Sort
		   for (int n=0; n<ary.length; n++)
			   System.out.println(ary[n] + " ");
		   
	}

}
