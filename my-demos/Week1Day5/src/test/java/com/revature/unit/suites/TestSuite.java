package com.revature.unit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.revature.unit.tests.McLarenFactoryTests;
import com.revature.unit.tests.OtherTests;
import com.revature.unit.tests.TestClass;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	TestClass.class,
	OtherTests.class,
	McLarenFactoryTests.class
	})
public class TestSuite {
	
}
