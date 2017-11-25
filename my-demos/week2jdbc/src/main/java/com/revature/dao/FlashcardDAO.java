package com.revature.dao;

import java.util.List;

import com.revature.beans.Flashcard;

public interface FlashcardDAO {
	
	/**
	 * Method used to save flashcards using a regular statement
	 * @param fc
	 */
	void badSave(Flashcard fc);
	
	
	/**
	 * Uses a Prepared Statement to create a flashcard
	 * @param fc
	 * @return 
	 */
	int betterSave(Flashcard fc);
	
	/**
	 * Uses a callable statement to create a flashcard
	 * @param fc
	 * @return 
	 */
	int storedProcedureSave(Flashcard fc);
	
	/**
	 * Finds all flashcards in the database
	 * @return
	 */
	List<Flashcard> findAll();
	
	
	/**
	 * Finds a single flashcard by the id
	 * @return
	 */
	Flashcard findById(int id);


	

}
