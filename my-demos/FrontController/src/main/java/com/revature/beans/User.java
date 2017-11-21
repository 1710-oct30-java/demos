package com.revature.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	private int userId;
	private String username;
	private String password;
	private List<FlashCard> flashCards;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String username, String password, List<FlashCard> flashCards) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.flashCards = flashCards;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<FlashCard> getFlashCards() {
		return flashCards;
	}

	public void setFlashCards(List<FlashCard> flashCards) {
		this.flashCards = flashCards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flashCards == null) ? 0 : flashCards.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (flashCards == null) {
			if (other.flashCards != null)
				return false;
		} else if (!flashCards.equals(other.flashCards))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", flashCards="
				+ flashCards + "]";
	}

}
