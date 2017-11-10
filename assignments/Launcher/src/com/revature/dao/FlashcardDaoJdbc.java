package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Flashcard;
import com.revature.beans.List;

public class FlashcardDaoJdbc implements FlashcardDAOJdbc {
	Logger log = Logger.getRootLogger();
	
	public void save(Flashcard fc) {
		
		try (Connection conn = DriverManager.getConnection("orcl.c1bg5czdo2ui.us-east-2.rds.amazonaws.com");
		Statement stmt = conn.createStatement();
		stmt.executeQuery("INSERT INTO flashcard (question, answer) VALUES ('" + fc.getQuestion() + "', '" + fc.getAnswer() + ")");
		
		System.out.println("successfully saved flashcard");
		}
		//
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to save the flashcard");
		}
	}
	
	public void betterSave (Flashcard fc) {
		log.debug("Attempting to save a new flashcard with a prepared statement");
		try(Connnection) {}
	}
	
	
	// Finds all flashcards in the database
	public List<Flashcard> findAll() {
		return null;
	}
	
	
	// Finds a single flash card by the id
	Flashcard findById() {
		return null;
	}
	
}
