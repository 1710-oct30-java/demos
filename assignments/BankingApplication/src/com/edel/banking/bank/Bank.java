package com.edel.banking.bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.edel.banking.account.Account;
import com.edel.banking.account.CheckingAccount;
import com.edel.banking.login.Login;
import com.edel.banking.serialization.Deserialize;
import com.edel.banking.serialization.Serialize;
import com.edel.banking.user.User;

/*
	Bank class manages all accounts and users
		- open account
		- close account and all user accounts
		- display all accounts
		- display accounts by user or accountID
		- maintain a list of current users
		- check if a users already exists
*/

public class Bank implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6004020496812266184L;

	private static List<Account> accounts = new ArrayList<Account>();
	private static List<User> users = new ArrayList<User>();
	private static List<Account> userAccounts = new ArrayList<Account>();
	private Account account;
	private User user;

	// Remove an account based on the account ID
	public void closeAccount(int ID)
	{
		Iterator<Account> itr = accounts.iterator();

		while (itr.hasNext())
		{
			Account acc = itr.next();
			if (acc.getID() == ID)
			{
				itr.remove();
			}
		}
	}

	// Close all accounts linked to the user
	public void closeAllUserAccounts(User user)
	{
		Iterator<Account> itr = accounts.iterator();

		while (itr.hasNext())
		{
			Account acc = itr.next();
			if (acc.getOwner().getEmail().equals(user.getEmail()))
			{
				itr.remove();
			}
		}
	}

	// Open a new account
	public void openAccount(Account acc)
	{
		// Set account ID
		for(Account a:accounts)
		{
			if(a.getType().equals(acc.getType()))
			{
				acc.setID(a.getID() + 1);
			}
		}
		
		// Add account to accounts list
		accounts.add(acc);

		// Add user to users list if possible
		addUserToList(acc.getOwner());
	}

	// Add user to list if the user does not exist
	public void addUserToList(User user)
	{
		if (!userExists(user))
		{
			users.add(user);
		}
	}

	// Check if user exists in the users list
	public boolean userExists(User user)
	{
		for (User u1 : users)
		{
			if (u1 == user)
			{
				return true;
			}
		}
		return false;
	}

	// Display all accounts in the list
	public void displayAccounts()
	{
		for (Account acc : accounts)
		{
			System.out.println(acc);
		}
		System.out.println();
	}

	// Display all accounts from parameter list
	public void displayAccounts(List<Account> accounts)
	{
		for (Account acc : accounts)
		{
			System.out.println(acc);
		}
		System.out.println();
	}

	// Display all user accounts by searching for user email
	public void displayAccountsByUser()
	{
		for (Account acc : accounts)
		{
			if(acc.getOwner().getEmail().equals(Login.getUser().getEmail()))
			{
				System.out.println(acc);
			}
			
		}
		System.out.println();
	}
	
	// Remove all accounts from temporary user accounts list
	public void removeAccountsFromUsersList()
	{
		userAccounts.clear();
	}
	
	// Set user accounts
	public void setUserAccounts(User user)
	{
		for (Account acc : accounts)
		{
			if (acc.getOwner().getEmail().equals(user.getEmail()))
			{
				userAccounts.add(acc);
			}
		}
		System.out.println();
	}

	// Display accounts by given ID
	public void displayAccountByID(int ID)
	{
		for (Account acc : accounts)
		{
			if (acc.getID() == ID)
			{
				System.out.println(acc);
			}
		}
		System.out.println();
	}

	// Return list of users
	public static List<User> getUsers()
	{
		return users;
	}
	
	// Set new list of users
	public static void setUsers(List<User> newUsers)
	{
		users = newUsers;
	}

	// Return list of accounts
	public static List<Account> getAccounts()
	{
		return accounts;
	}
	
	// Set list of accounts
	public static void setAccounts(List<Account> newAccounts)
	{
		accounts = newAccounts;
	}
	
	// Create new user and to users list
	public void createUser(String firstName, String lastName, String email, String password)
	{
		User newUser = new User(firstName, lastName, email, password);
		addUserToList(newUser);
	}
	
	// Check if ID entered matches a user's account
	// Avoids changing other users account
	public boolean idMatchesUser(int ID, User user)
	{
		for(Account acc:userAccounts)
		{
			if(ID == acc.getID())
			{
				return true;
			}
		}
		return false;
	}
	
	// Check if account exists with that ID
	public boolean accountExists(int ID)
	{
		for(Account acc:getAccounts())
		{
			if(acc.getID() == ID)
			{
				return true;
			}
		}
		return false;
	}
	
	// Return account by given ID
	public Account getAccount(int ID)
	{
		for(Account acc:getAccounts())
		{
			if(acc.getID() == ID)
			{
				account = acc;
			}
		}
		/*
		if(account == null)
		{
			account = new CheckingAccount();
		}
		*/
		return account;
	}
	
	// SERIALIZATION BELOW FOR ACCOUNT AND USER DATA
	// Serialize (save) all user data to file
	public void saveUserData()
	{
		Serialize.serializeUsers();
	}
	
	// Deserialize (get/return) all account data from file
	public void retreiveUserData()
	{
		Deserialize.deserializeUsers();
	}
	
	// Serialize (save) all account data to file
	public void saveAccountData()
	{
		Serialize.serializeAccounts();
	}
	
	// Deserialize (get/return) all account data from file
	public void retreiveAccountData()
	{
		Deserialize.deserializeAccounts();
	}
}
