package com.bank.auth;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.accounts.User;

public class PopData implements Serializable
{
	private List<Object> master = new ArrayList<>();
	private Map<String, User> userU = new HashMap<>();
	private List<Integer> idUsed = new ArrayList<>();

	public PopData()
	{
		super();

		// De-serialize the Object to obtain data
	}

	public void makeAdmin()
	{
		User temp = new User();
		temp.setName("ADMIN");
		temp.setPassword("1234");
		userU.put("admin", temp);
		logOut();
	}
	
	
	public void getData()
	{
		try
		{
			FileInputStream fis = new FileInputStream("UsersCred");
			ObjectInputStream ois = new ObjectInputStream(fis);
			master = (List<Object>) ois.readObject();
			ois.close();
			fis.close();
		}
		catch (FileNotFoundException fnfe)
		{
			makeAdmin();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			return;
		} 
		catch (ClassNotFoundException c)
		{
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
		finally
		{		
			// get users and usersBanks object from file
			userU = (Map<String, User>) master.get(0);
			idUsed = (List<Integer>) master.get(1);
		}
	}
	public void logOut()
	{
		master = new ArrayList<>();
		master.add(userU);
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


	public Map<String, User> getUserU()
	{
		return userU;
	}

	public void addUserU(String username, User userObj)
	{
		userU.put(username, userObj);
	}

	public List<Integer> getIdUsed()
	{
		return idUsed;
	}

	public void setIdUsed(List<Integer> idUsed)
	{
		this.idUsed = idUsed;
	}



}
