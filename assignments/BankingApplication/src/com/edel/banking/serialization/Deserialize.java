package com.edel.banking.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

import com.edel.banking.account.Account;
import com.edel.banking.bank.Bank;
import com.edel.banking.user.User;

public class Deserialize implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7116928604659928152L;
	
	

	// Deserialize and returns list of users
	public static List<User> deserializeUsers()
	{
		try
		{
			List<User> tmp_users = null;
			
			FileInputStream fileIn = new FileInputStream(Serialize.usersFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			tmp_users = (List<User>) in.readObject();
			Bank.setUsers((tmp_users));

			in.close();
			fileIn.close();
		} catch (FileNotFoundException e)
		{
			
		}catch (IOException e)
		{
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e)
		{
			System.out.println("Class not found");
			e.printStackTrace();
			return null;
		}
		return Bank.getUsers();
	}

	// Deserialize and returns list of accounts
	public static List<Account> deserializeAccounts()
	{
		try
		{
			List<Account> tmp_accounts = null;
			
			FileInputStream fileIn = new FileInputStream(Serialize.accountsFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			tmp_accounts = (List<Account>) in.readObject();
			Bank.setAccounts(tmp_accounts);

			in.close();
			fileIn.close();
		} catch (FileNotFoundException e)
		{
			
		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e)
		{
			System.out.println("Class not found");
			e.printStackTrace();
			return null;
		}
		return Bank.getAccounts();
	}
}
