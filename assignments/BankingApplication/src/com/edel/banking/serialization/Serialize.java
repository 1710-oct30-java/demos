package com.edel.banking.serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import com.edel.banking.bank.Bank;

public class Serialize implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5901379296160307420L;
	
	private static File usersFile = new File("src/user_login.txt");
	private static File accountsFile = new File("src/user_accounts.txt");

	public static void serializeUsers()
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream(usersFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(Bank.getUsers());

			out.close();
			fileOut.close();

			System.out.printf("Users data serialized!\n");
		} catch (FileNotFoundException e)
		{
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void serializeAccounts()
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream(accountsFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(Bank.getAccounts());

			out.close();
			fileOut.close();

			System.out.printf("Accounts data serialized!\n");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
