package com.revature.beans;

import java.util.List;

public class User {
	private int userID;
	private String username;
	private String password;
	private List<Flashcard> flashCards;
	
	public User() {
		super();
	}
	
	public User(int userID, String username, String password, List<Flashcard> flashCards) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.flashCards = flashCards;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Flashcard> getFlashCards() {
		return flashCards;
	}
	public void setList(List<Flashcard> flashCards) {
		this.flashCards = flashCards;
	}

}
