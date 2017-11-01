package com.homeworkOne.problemTwelve;

public class ProblemTwelve {
	//Print even numbers from 1-100
	public static void main(String[] args) {
		int[] numbers = new int[100];
		
		for(int i=0; i<100; i++)
		{
			numbers[i] = i+1;
		}
		
		for(int even: numbers)
		{
			if(even%2 == 0)
				System.out.println(even);
		}
	}
}
