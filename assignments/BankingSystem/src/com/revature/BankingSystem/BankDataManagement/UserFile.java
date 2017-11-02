package com.revature.BankingSystem.BankDataManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.BankingSystem.BankClasses.Account;

public class UserFile {

	public static UserList loadUserList() {
		// loads user list that has been previously saved
		FileInputStream fileIn;
		UserList userList = new UserList();
		try {
			fileIn = new FileInputStream("userList.txt");
			ObjectInputStream in;
			try {
				in = new ObjectInputStream(fileIn);
				try {
					userList = (UserList) in.readObject();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				in.close();
				fileIn.close();
				if (userList.getClientList() != null && userList.getClientList().size() > 0) {
					if (userList.getClientList().get(0).getAccounts().size() > 0) {
						Account a = userList.getClientList().get(0).getAccounts().get(0);
						a.setNumAcc(userList.getClientList().get(0).getAccounts().size());
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			// /e1.printStackTrace();
		}

		return userList;
	}

	public static boolean saveUserList(UserList userList) {
		// saves current userList into Serialized data file
		try {
			FileOutputStream fileOut = new FileOutputStream("userList.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(userList);
			out.close();
			fileOut.close();
			System.out.print("Serialized data is saved in userList.txt");
			return true;

		} catch (IOException i) {
			i.printStackTrace();
			return false;
		}
	}

}
