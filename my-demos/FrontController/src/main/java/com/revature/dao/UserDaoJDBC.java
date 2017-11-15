package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.FlashCard;
import com.revature.beans.User;

public class UserDaoJDBC implements UserDao {
	private Logger log = Logger.getRootLogger();
	private static List<User> allUsers;
	{
		allUsers = new ArrayList<User>();
		allUsers.add(new User(1, "blake", "pass", new ArrayList<FlashCard>()));
		List<FlashCard> chrisCards = new ArrayList<FlashCard>();
		chrisCards.add(new FlashCard(1, "what is java", "An object oriented programming language"));
		chrisCards.add(new FlashCard(2, "What is Restful", "Restful is a type of web services that uses JSON or XML and is stateless"));
		allUsers.add(new User(2, "chris w.", "not telling me", chrisCards));
	}

	public List<User> findAll() {
		return allUsers;
	}

	@Override
	public void addFlashCardToBlake(FlashCard fc) {
		log.debug("adding flashcard to blakes flashcards");
		allUsers.get(0).getFlashCards().add(fc);
	}

}
