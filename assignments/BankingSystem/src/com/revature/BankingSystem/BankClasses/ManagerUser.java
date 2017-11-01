package com.revature.BankingSystem.BankClasses;

import java.util.ArrayList;

public class ManagerUser extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8391357534823744863L;
	private ArrayList<Integer> clients;

	public ManagerUser(String userName, String firstName, String lastName, String password) {
		super(userName, firstName, lastName, password);
		clients = new ArrayList<>();
	}

	public void addClient(ClientUser cUser) {
		clients.add(cUser.getUserId());
	}

	public void removeAccount(int i) {
		clients.remove(i);
	}

	public ArrayList<Integer> getClients() {
		return clients;
	}

	@Override
	public String toString() {
		return "ManagerUser [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

}
