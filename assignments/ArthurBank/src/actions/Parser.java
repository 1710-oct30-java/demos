package actions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import objects.Account;
import objects.User;

public class Parser {

	public ArrayList<User> ParseUser() throws FileNotFoundException {

		// parses user objects from userList.txt that is of form {userid, firstname,
		// lastname, username, password} for each line and stores it in the current
		// instance of arraylist userData

		FileReader userList = new FileReader("userList.txt");
		BufferedReader br = new BufferedReader(userList);
		Scanner ul = new Scanner(br);
		ArrayList<User> userData = new ArrayList<User>();
		ArrayList<String> userParse = new ArrayList<String>();

		while (ul.hasNextLine()) {
			userParse.addAll(Arrays.asList(ul.nextLine().split(",")));
		}

		for (int i = 0; i < userParse.size() - 1; i += 5) {
			userData.add(new User(userParse.get(i), userParse.get(i + 1), userParse.get(i + 2), userParse.get(i + 3),
					userParse.get(i + 4)));
		}

		return userData;
	}

	public ArrayList<Account> ParseAccount() throws FileNotFoundException {
		
		// parses account objects from accountList.txt that is of form {accID, userID,
		// balance, type} and stores it in the current instance of arraylist accountData
		
		FileReader accountList = new FileReader("accountList.txt");
		BufferedReader br = new BufferedReader(accountList);
		Scanner al = new Scanner(br);

		ArrayList<Account> accountData = new ArrayList<Account>();
		ArrayList<String> accountParse = new ArrayList<String>();

		while (al.hasNextLine()) {
			accountParse.addAll(Arrays.asList(al.nextLine().split(",")));
		}

		for (int i = 0; i < accountParse.size() - 1; i += 4) {
			accountData.add(new Account(accountParse.get(i), accountParse.get(i + 1),
					Double.parseDouble(accountParse.get(i + 2)), accountParse.get(i + 3)));
		}

		return accountData;

	}

}
