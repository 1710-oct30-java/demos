package com.revature.comparators;

public class Sorter {
	
	static public void sort(Object[] arr) {
		Comparable<Object>[] compArr = (Comparable<Object>[]) arr;
		boolean flag = false;
		while(!flag) {
			flag = true;
			for(int i = 0; i < compArr.length - 1; i++) {
				if(compArr[i].compareTo(compArr[i+1]) < 0 ) {
					Comparable temp = compArr[i];
					compArr[i] = compArr[i+1];
					compArr[i+1] = temp;
					flag = false;
				}
			}
		}
	}
}
