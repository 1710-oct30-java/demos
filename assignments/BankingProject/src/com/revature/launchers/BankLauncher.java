package com.revature.launchers;

/*
 * Class: BankLauncher
 * Creator: Kyle Settles
 * Description: Class used to run the banking application. Contains methods used
 * to save and load the current state of the bank.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

import com.revature.beans.*;

public class BankLauncher {
	public FileOutputStream fos = null;
	public ObjectOutputStream out = null;
	public FileInputStream fin = null;
	
	public boolean saveBank(List<User> listUser) {
		try {
			fos = new FileOutputStream("data.txt", false);
			out = new ObjectOutputStream(fos);
			out.writeObject(listUser);
			out.close();
			System.out.println("successfully saved state");
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> loadBank() {
		try {
			fin = new FileInputStream("data.txt");
			ObjectInputStream oos = new ObjectInputStream(fin);
			ArrayList<User> loaded = (ArrayList<User>) oos.readObject();
			System.out.println("successfully loaded object");
			return loaded;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		BankLauncher test = new BankLauncher();
		List<User> loaded = test.loadBank();
		Bank testBank = new Bank(loaded);
		test.saveBank(testBank.getListUsers());
	}
}