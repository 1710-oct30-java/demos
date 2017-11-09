package com.revature.dao;

import java.util.List;

import com.revature.beans.Flashcard;

public interface FlashcardDAO {
	
	public void procedureSave(Flashcard fc);
	public void preparedProcedureSave(Flashcard fc);
	public int storedProcedureSave(Flashcard fc);
	public List<Flashcard> findall();
	public Flashcard findById(int id);
}
