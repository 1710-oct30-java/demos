package com.revature.BankingSystem.BankDataManagement;

import java.io.Serializable;
import java.util.ArrayList;

import com.revature.BankingSystem.BankClasses.*;

public class UserList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 838653798135373899L;
	private ArrayList<User> userList = new ArrayList<>();

	public UserList() {
		userList = new ArrayList<>();
	}

	public UserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public User get(int i) {
		return userList.get(i);
	}

	public User getID(int id) {
		for (User ele : userList) {
			if (ele.getUserId() == id) {
				return ele;
			}
		}
		return null;
	}

	public int numberOfUsers() {
		return userList.size();
	}

	public ArrayList<ClientUser> getCLientList() {
		ArrayList<ClientUser> clients = new ArrayList<>();
		for (User ele : userList) {
			if (ele.getClass() == ClientUser.class) {
				clients.add((ClientUser) ele);
			}
		}
		return clients;
	}

	public ArrayList<ManagerUser> getManagerList() {
		ArrayList<ManagerUser> managers = new ArrayList<>();
		for (User ele : userList) {
			if (ele.getClass() == ManagerUser.class) {
				managers.add((ManagerUser) ele);
			}
		}
		return managers;
	}

	public void addClientUser(String userName, String firstName, String lastName, String password) {
		userList.add(new ClientUser(userName, firstName, lastName, password));
	}

	public void addClientUser(ClientUser newClient) {
		userList.add(newClient);
	}

	public void addManagerUser(String userName, String firstName, String lastName, String password) {
		userList.add(new ManagerUser(userName, firstName, lastName, password));
	}

	public void addManagerUser(ManagerUser newClient) {
		userList.add(newClient);
	}

	@Override
	public String toString() {
		String out = "UserList = [";
		for (User ele : userList) {
			out += "\n\t" + ele;
		}
		return out + "\n]";

	}
}
