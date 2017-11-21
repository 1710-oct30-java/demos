package com.revature.unit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class OtherTests {

	@Test
	public void someTest() {
		assertTrue(false);
	}

	@Test(expected = NullPointerException.class)
	public void exceptionTest() {
		throw new NullPointerException();
	}
	
	@Test
	public void sorted() {
		int[] arr = { 1,2,4,3,6};
		Arrays.sort(arr);
		int[] expected = {1,2,3,4,6};
		assertTrue(Arrays.equals(arr, expected));
	}

}
