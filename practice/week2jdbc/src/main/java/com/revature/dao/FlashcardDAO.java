package com.revature.dao;

import java.util.List;

import com.revature.beans.Flashcard;

public interface FlashcardDAO
{
	/*
	 * Save a flashcard
	 * @param fc
	 */
	void save(Flashcard fc);
	
	void betterSave(Flashcard fc);
	
	
	List<Flashcard> findAll();
	
	/*
	 * Finds a single flashcard by the d
	 * @return
	 */
	Flashcard findById();
	
}
