package com.homeworkOne.problemTwelve;

public class ProblemTwelve {
	//Print even numbers from 1-100
	public static void main(String[] args) {
		//Init variables
		int[] numbers = new int[100];
		
		//add numbers to array
		for(int i=0; i<100; i++)
		{
			numbers[i] = i+1;
		}
		
		//Print even numbers
		for(int even: numbers)
		{
			if(even%2 == 0)
				System.out.println(even);
		}
	}
}
