package com.revature.testable;

import java.util.List;
import java.util.stream.Collectors;

public class TestableClass {
	
	public List<Integer> multiplyByTwo(List<Integer> ints) {
		return ints.stream()
				.map(i -> i*2)
				.collect(Collectors.toList());
	}
}
