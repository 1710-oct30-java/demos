package com.revature.BankingSystem.BankingLauncher;

import com.revature.BankingSystem.BankClasses.ClientUser;
import com.revature.BankingSystem.BankDataManagement.UserFile;
import com.revature.BankingSystem.BankDataManagement.UserList;

import com.revature.BankingSystem.BankingUI.MenuControl;

public class BankingLauncher {
	static UserList userList;

	public static void main(String[] args) {
		// userList = new UserList();
		// userList.addClientUser("john123", "John", "Doe", "password");
		// ((ClientUser) userList.getID(0)).addAccount("checking", 100.00);
		// ((ClientUser) userList.getID(0)).addAccount("checking", 100.00);
		// ((ClientUser) userList.getID(0)).addAccount("checking", 100.00);
		// ((ClientUser) userList.get(0)).addAccount("checking", 100.00);
		//
		// userList.addClientUser("john1234", "John", "Doe", "password");
		// ((ClientUser) userList.get(1)).addAccount("checking", 100.00);
		//
		// userList.addManagerUser("manage", "John", "Doe", "password");
		// UserFile.saveUserList(userList);

		userList = UserFile.loadUserList();
		System.out.println(userList);
		// for(User ele : userList) {
		// System.out.println(ele.getClass());
		// }
		// System.out.println(UserA.getAccounts().get(0));
		// UserLogin UL = new UserLogin();
		// UL.login(userList);
		// AccountManager AM = new AccountManager(UserA);
		// AM.AccounManagment();
		// MenuControl MC = new MenuControl(userList);
		// MC.mainMenu();

		// try {
		// FileInputStream fileIn = new FileInputStream("userList.txt");
		// ObjectInputStream in = new ObjectInputStream(fileIn);
		// userList = (UserList) in.readObject();
		// in.close();
		// fileIn.close();
		// System.out.println(userList);
		// } catch (IOException i) {
		// i.printStackTrace();
		// return;
		// } catch (ClassNotFoundException c) {
		// System.out.println("UserList class not found");
		// c.printStackTrace();
		// return;
		// }

	}

}
