package com.revature.bankingproject.tests;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bankingproject.user.DuplicateUserException;
import com.revature.bankingproject.user.LoginHandler;
import com.revature.bankingproject.user.User;

public class UserTests {
	private static Logger log = Logger.getRootLogger();
	private List<User> users;
	private LoginHandler ut = new LoginHandler();

	@BeforeClass
	public static void beforeEverything() {
		log.info("Beginning Account Tests");
	}

	@Before
	public void beforeAllUserTests() {
		users = new LinkedList<User>();
	}

	@Test
	public void testCreateWithNullUsers() throws DuplicateUserException {
		User a = new User(User.userIdCount, "Bill", "123", "bill@bill.com");
		ut.create("Bill", "123", "bill@bill.com", users);
		assertTrue(users.contains(a));
	}

	@Test
	public void testCreateWithMultipleUsers() throws DuplicateUserException {
		User a = new User(1, "Bill", "123", "bill@bill.com");
		User b = new User(2, "Tom", "123", "bill@bill.com");
		User c = new User(3, "A", "B", "C");
		User d = new User(5, "B", "B", "D");
		users.add(a);
		users.add(b);
		users.add(c);
		users.add(d);
		User e = new User(User.userIdCount, "C", "c", "d");
		ut.create("C", "c", "d", users);
		assertTrue(users.contains(e));
	}

	@Test(expected = DuplicateUserException.class)
	public void testCreateDuplicateEmailWithOneUsers() throws DuplicateUserException {
		ut.create("Bill", "1", "1", users);
		ut.create("Tom", "1", "1", users);
	}

	@Test(expected = DuplicateUserException.class)
	public void testCreateDuplicateEmailWithMultipleUsers() throws DuplicateUserException {
		User a = new User(1, "Bill", "123", "bill@bill.com");
		User b = new User(2, "Tom", "123", "bill@bill.com");
		User c = new User(3, "A", "B", "C");
		User d = new User(5, "B", "B", "D");
		users.add(a);
		users.add(b);
		users.add(c);
		users.add(d);
		ut.create("B", "B", "D", users);
	}

	@After
	public void afterAllUserTests() {
		users = null;
	}

}
