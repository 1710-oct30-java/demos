package com.revature.unit.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.testable.TestableBubbleSort;

public class BubbleTests {
	List<Integer> myTestList;
	List<Integer> myTestListExpected;
	
	@Before
	public void beforeTest() {
		myTestList = new ArrayList<>();
		myTestList.add(5);
		myTestList.add(10);
		myTestList.add(0);
		myTestList.add(-50);
		myTestList.add(10);
		myTestList.add(1);
		
		myTestListExpected.addAll(myTestList);
		myTestListExpected.sort(null);
	}
	
	@Test
	public void testBubbleInts() {
		TestableBubbleSort<Integer> mySorter = new TestableBubbleSort<>();
		mySorter.bubbleSort(myTestList);
	}
}
