package com.revature.Q12;

public class EvenNumbersArray {
	public static void main(String[] args) {
		int[] numberList = new int[100];
		
		for(int i = 1; i <= 100; i++) {
			numberList[i-1] = i;
		}
		
		for(Integer element : numberList) {
			if(element%2==0) {
				System.out.println(element);
			}
		}
		
	}
}
