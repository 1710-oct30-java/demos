package com.revature.unit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.testable.TestableClass;

public class TestClass {
	private static Logger log = Logger.getRootLogger();
	private List<Integer> intList;
	private TestableClass tc = new TestableClass();

	@BeforeClass
	public static void runOnceBeforeAllTests() {
		log.info("Initialization before all tests complete");
	}

	@Before
	public void createList() {
		log.info("before each test");
		intList = new ArrayList<>();
		intList.add(25);
		intList.add(15);
		intList.add(10);
	}

	@Test
	public void testResults() {
		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(50);
		expectedList.add(30);
		expectedList.add(20);
		assertEquals(tc.multiplyByTwo(intList), expectedList);
	}

	@Test
	public void testOriginal() {
		assertNotSame(tc.multiplyByTwo(intList), intList);
	}

	@After
	public void after() {
		log.info("after each test");
	}
	
	
	@AfterClass
	public static void afterAll() {
		log.info("all tests are done");
	}

}
