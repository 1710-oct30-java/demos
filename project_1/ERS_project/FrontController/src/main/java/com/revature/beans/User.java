package com.revature.beans;

import java.util.List;

public class User {
	private int user_id;
	private String username;
	private String password;
	private List<FlashCard> flashcards;
	
	public User() {
		super();
	}



	public User(int user_id, String username, String password, List<FlashCard> flashcards) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.flashcards = flashcards;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
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



	public List<FlashCard> getFlashcards() {
		return flashcards;
	}



	public void setFlashcards(List<FlashCard> flashcards) {
		this.flashcards = flashcards;
	}



	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", flashcards="
				+ flashcards + "]";
	}
	
}
