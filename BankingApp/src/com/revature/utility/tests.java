package com.revature.utility;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;

public class tests {
	
	private static Serializer<List<User>> userListSerializer = new Serializer<>();
	private static Serializer<List<Account>> accountListSerializer = new Serializer<>();
	public static void main(String[] args) {
		
		List<Account> y = new ArrayList<Account>();
		
		Account account = new Account("i", 0, "i", 0);
		
		y.add(account);
		System.out.println(y.toString());
		
		accountListSerializer.writeObject(y, "accounts.txt");
		
		List<Account> accountList = accountListSerializer.readObject("accounts.txt");

	}
}
