package com.revature.Q19;

import java.util.ArrayList;
import java.util.List;

public class Integers {
	public static void main(String[] args) {
		List<Integer> numberList = new ArrayList<Integer>();
		int evenSum = 0;
		int oddSum = 0;
		
		for(int i = 1; i < 11; i++) {
			numberList.add(i);
		}
		
		for(int j = 0; j < 10; j++) {
			if((numberList.get(j) % 2) == 0) {
				evenSum = evenSum + numberList.get(j);
			}
			else {
				oddSum = oddSum + numberList.get(j);
			}
		}
		System.out.println(evenSum);
		System.out.println(oddSum);
		
		numberList.remove(0);
		numberList.remove(0);
		
		for(int k = 0; k < numberList.size(); k++) {
			
			boolean prime = true;
			
			for (int l = 2; l < numberList.get(k); l++) {
				
				if(numberList.get(k)%l == 0) {
				
					prime = false;
				
				}
				
				else {
					
				}
			}
			
			if(prime==true) {
				numberList.remove(k);
			}
		}
		System.out.println(numberList);
		
	}

}
