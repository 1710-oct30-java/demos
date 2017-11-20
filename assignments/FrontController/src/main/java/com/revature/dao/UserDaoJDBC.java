package com.revature.dao;

public class UserDaoJDBC implements UserDao {
	private List<User> allUsers;
	{
		allUsers = new ArrayList<User>();
		allUsers.add(new User(1, "blake", "pass", new ArrayList<FlashCard>()));
		List<FlashCard> chrisCards = new ArrayList<FlashCard>(); 
		chrisCards.add(new FlashCard(2, "what is java", "an object oriented programming language"));
		chrisCards.add(new FlashCard(3, "what is a servlet", "a java object that handles requests and responses"));
	}
	
	public List<User> findAll() {
		return allUsers;
	}
}
