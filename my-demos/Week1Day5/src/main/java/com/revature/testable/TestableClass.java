package com.revature.testable;

import java.util.ArrayList;
import java.util.List;

public class TestableClass {
	public List<Integer> multiplyByTwo(List<Integer> ints) {
		List<Integer> newList = new ArrayList<>();
		for(int i: ints) {
			newList.add(i*2);
		}
		return newList;
	}
}
