package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;
import com.revature.dao.FlashcardDAOJdbc;

public class AddFlashcardScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private FlashcardDAO fcdao = new FlashcardDAOJdbc();
	
	@Override
	public Screen run() {
		Flashcard fc = new Flashcard();
		System.out.println("Enter question");
		fc.setQuestion(scan.nextLine());
		System.out.println("Enter answer");
		fc.setAnswer(scan.nextLine());
		System.out.println("Added Flashcard");
		
		fcdao.betterSave(fc);
		
		return new MainMenuScreen();
	}

}
