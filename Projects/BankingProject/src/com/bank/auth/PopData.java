package com.bank.auth;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.accounts.Account;

public class PopData implements Serializable
{
	private List<Object> master = new ArrayList<>();
	private Map<String, String> userPass = new HashMap<>();
	private Map<String, List<Account>> usersBanks = new HashMap<>();
	private List<Integer> idUsed = new ArrayList<>();

	public PopData()
	{
		super();

		// De-serialize the Object to obtain data
		try
		{
			FileInputStream fis = new FileInputStream("UsersCred");
			ObjectInputStream ois = new ObjectInputStream(fis);
			master = (List<Object>) ois.readObject();
			ois.close();
			fis.close();

			// get users and usersBanks object from file
			userPass = (Map<String, String>) master.get(0);
			usersBanks = (Map<String, List<Account>>) master.get(1);
			idUsed = (List<Integer>) master.get(2);

		} catch (IOException ioe)
		{
			ioe.printStackTrace();
			return;
		} catch (ClassNotFoundException c)
		{
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
	}

	public void logOut()
	{
		master = new ArrayList<>();
		master.add(userPass);
		master.add(usersBanks);
		master.add(idUsed);

		try
		{
			FileOutputStream fos = new FileOutputStream("UsersCred", false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(master);
			oos.close();
			fos.close();
		} catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}



	public Map<String, String> getUserpass()
	{
		return userPass;
	}

	public void setUserpass(String username, String password)
	{
		userPass.put(username, password);
	}

}
