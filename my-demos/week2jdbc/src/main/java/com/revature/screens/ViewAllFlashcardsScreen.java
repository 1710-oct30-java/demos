package com.revature.screens;

import java.util.List;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;
import com.revature.dao.FlashcardDAOJdbc;

public class ViewAllFlashcardsScreen implements Screen {
	private FlashcardDAO fcdao = new FlashcardDAOJdbc();

	@Override
	public Screen run() {
		List<Flashcard> flashcards = fcdao.findAll();
		flashcards.sort((one, two) -> one.getId() - two.getId());
		System.out.println(flashcards);

		return new MainMenuScreen();
	}

}
