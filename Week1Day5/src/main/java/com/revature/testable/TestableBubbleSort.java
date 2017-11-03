package com.revature.testable;

import java.util.List;

public class TestableBubbleSort<T> {

	public void bubbleSort(List<Comparable<T>> t) {
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i = 1; i < t.size(); i++) {
				if(t.get(i-1).compareTo((T) t.get(i)) < 0 ) {
					Comparable<T> c = t.get(i-1);
					t.set(i-1, t.get(i));
					t.set(i, c);
					sorted = false;
				}
			}	
		}
	}
}
