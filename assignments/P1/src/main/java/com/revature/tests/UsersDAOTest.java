package com.revature.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.User;
import com.revature.dao.UsersDAO;
import com.revature.dao.UsersDAOjdbc;

public class UsersDAOTest {
	private static UsersDAO udao = UsersDAOjdbc.getUserDAOjdbc();
	private static User u;
	private static User u1;
	public UsersDAOTest() {
	}
	@BeforeClass
	public static void beforeAllTests()
	{
		u = new User(1, "joes","x","joe","sam","joesam@gmail.com",1,"Y");
		u1 = new User(2,"a","s","a","a","s",1,"N");
		
	}
	@Before
	public void beforeEachTest()
	{
		
	}
	@Test
	public void addUserTest()
	{
		assertTrue(udao.clearUserTable());
		assertTrue(udao.addUser(u));
		assertTrue(udao.addUser(u1));
	}
	@Test
	public void alterUsersTest()
	{
		//True Block
		
		assertTrue(udao.alterUserEmailById(1, "newEmailFor1"));
		assertTrue(udao.alterUserEmailById(2, "NewEmail2"));
		assertTrue(udao.alterUserIdById(1, 1));
		assertTrue(udao.alterUserUserNameById(1, "newUsername1"));
		assertTrue(udao.alterUserUserNameById(2, "newUsername2"));
		assertTrue(udao.alterUserPasswordById(1, "NewPassword1"));
		assertTrue(udao.alterUserPasswordById(2, "newpassword2"));
		assertTrue(udao.alterUserFirstNameById(1, "newFirstname1"));
		assertTrue(udao.alterUserFirstNameById(2, "newFirstName2"));
		assertTrue(udao.alterUserLastNameById(1, "newlastname1"));
		assertTrue(udao.alterUserLastNameById(2, "newlastname2"));
		assertTrue(udao.alterUserRoleIdById(1, 2));
		assertTrue(udao.alterUserRoleIdById(2, 2));
		
		//False Block
		//assertFalse(udao.alterUserById(1, u1));
		//assertFalse(udao.alterUserById(2, u));
		assertFalse(udao.alterUserEmailById(4, "won'twork"));
		assertFalse(udao.alterUserUserNameById(3, "won'twork"));
		assertFalse(udao.alterUserPasswordById(8, "won'twork"));
		assertFalse(udao.alterUserFirstNameById(7, "wont'work"));
		assertFalse(udao.alterUserLastNameById(8, "wont'work"));
		assertFalse(udao.alterUserRoleIdById(1222, 1));
		assertFalse(udao.alterUserRoleIdById(1, 444));
	}
	@Test
	public void removeUsersTest()
	{
		assertTrue(udao.removeUserById(1));
		assertTrue(udao.removeUserById(2));
		udao.addUser(u);
		udao.addUser(u1);
		assertTrue(udao.clearUserTable());
	}
	
	@After
	public void afterEachTest()
	{
		
	}
	@AfterClass
	public static void afterAllTests()
	{
		
	}
	
}
