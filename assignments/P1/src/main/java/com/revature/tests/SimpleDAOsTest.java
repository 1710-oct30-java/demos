package com.revature.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.SimpleDAOs;
import com.revature.dao.SimpleDAOsjdbc;

public class SimpleDAOsTest {
	private static SimpleDAOs rsdao = new SimpleDAOsjdbc("reimbursement_status", "status_id", "status");
	private static SimpleDAOs rtdao = new SimpleDAOsjdbc("reimbursement_type", "type_id", "type");
	private static SimpleDAOs urdao = new SimpleDAOsjdbc("user_roles", "user_role_id", "user_role");
	public SimpleDAOsTest() {

	}
	
	@BeforeClass
	public static void beforeAllSimpleDAOTests()
	{
		
	}
	
	@Before
	public void beforeEachSimpleDAOTest()
	{
		
	}
	
	@Test
	public void rsdaoTest()
	{
		//true Block
		assertTrue(rsdao.add(3, "punk"));
		assertTrue(rsdao.add(4, "greeter"));
		assertTrue(rsdao.alter(4, "greeter", 4, "Person"));
		assertTrue(rsdao.alterById(4, 4, "fired"));
		assertTrue(rsdao.alterByName("fired", 3, "bagger"));
		assertTrue(rsdao.alterNameById(4, "The ten!"));
		assertTrue(rsdao.alterNamebyName("The ten!", "Nothing"));
		assertTrue(rsdao.remove(4,"Nothing"));
		assertTrue(rsdao.removeById(3));
		
		//false Block
		assertFalse(rsdao.alter(10101, "boe", 10101001, "boe"));
		assertFalse(rsdao.alterById(1010100101, 1, "boe"));
		assertFalse(rsdao.alterByName("", 1, ""));
		assertFalse(rsdao.alterNamebyName("", ""));
		
	}
	
	@Test
	public void rtdaoTest()
	{
		//true Block
		assertTrue(rtdao.add(5, "punk"));
		assertTrue(rtdao.add(7, "greeter"));
		assertTrue(rtdao.alter(5, "punk", 5, "Person"));
		assertTrue(rtdao.alterById(5, 5, "fired"));
		assertTrue(rtdao.alterByName("fired", 5, "bagger"));
		assertTrue(rtdao.alterNameById(5, "The ten!"));
		assertTrue(rtdao.alterNamebyName("The ten!", "Nothing"));
		assertTrue(rtdao.remove(5,"Nothing"));
		assertTrue(rtdao.removeById(6));
		
		//false Block
		assertFalse(rtdao.alter(10101, "boe", 10101001, "boe"));
		assertFalse(rtdao.alterById(1010100101, 1, "boe"));
		assertFalse(rtdao.alterByName("", 1, ""));
		assertFalse(rtdao.alterNamebyName("", ""));
	}
	
	@Test
	public void urdaoTest()
	{
		//true Block
		assertTrue(urdao.add(5, "punk"));
		assertTrue(urdao.add(4, "greeter"));
		assertTrue(urdao.alter(3, "punk", 3, "honorable Person"));
		assertTrue(urdao.alterById(3, 3, "fired"));
		assertTrue(urdao.alterByName("fired", 3, "bagger"));
		assertTrue(urdao.alterNameById(3, "The ten!"));
		assertTrue(urdao.alterNamebyName("The ten!", "Nothing"));
		assertTrue(urdao.remove(3,"Nothing"));
		assertTrue(urdao.removeById(4));
		
		//false Block
		assertFalse(urdao.alter(11, "boe", 12, "boe"));
		assertFalse(urdao.alterById(13, 1, "boe"));
		assertFalse(urdao.alterByName("", 1, ""));
		assertFalse(urdao.alterNamebyName("", ""));
	}
	
	@After
	public void afterEachSimpleDAOTest()
	{
		
	}
	@AfterClass
	public static void afterAllSimpleDAOTest()
	{
		
	}

}
