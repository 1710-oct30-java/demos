package com.revature.bankingproject.tests;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bankingproject.inputvalidator.InputValidator;

public class AccountTests {
	private static Logger log = Logger.getRootLogger();
	@BeforeClass
	public static void beforeEverything()
	{
		log.info("Beginning Account Tests");
	}
	
	@Test
	public void testValidAmount()
	{
		assertEquals(null, InputValidator.validateDollarAmount("10a"));
		assertEquals("10",InputValidator.validateDollarAmount("10"));
		assertEquals("10.01",InputValidator.validateDollarAmount("10.01"));
		assertEquals("1",InputValidator.validateDollarAmount("1"));
		assertEquals(null,InputValidator.validateDollarAmount("aasdlfjvoixqwoerjlasdkf12039asdkfljzvio10.20"));
		assertEquals("11000020200128318239127293829292.23",InputValidator.validateDollarAmount("11000020200128318239127293829292.23"));
	}
	
	@Test
	public void testVerifyAccountId()
	{
		assertEquals(-1, InputValidator.validateAccountId("as", false, null));
		assertEquals(-1, InputValidator.validateAccountId("013738a", false, null));
		assertEquals(-1,InputValidator.validateAccountId("112341234187397a182394", false, null));
		assertEquals(10, InputValidator.validateAccountId("10", false, null));
		assertEquals(10123, InputValidator.validateAccountId("10123", false, null));
	}
	
	
}
