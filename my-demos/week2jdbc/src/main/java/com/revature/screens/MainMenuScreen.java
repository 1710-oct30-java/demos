package com.revature.screens;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen run() {
		System.out.println("Enter 1 to add a new flashcard");
		System.out.println("Enter 2 to view all flashcards");
		System.out.println("Enter 3 to view a flashcard by id");

		String choice = scan.nextLine();

		switch (choice) {
		case "1":
			return new AddFlashcardScreen();

		case "2":
			return new ViewAllFlashcardsScreen();

		case "3":
			return new ViewFlashcardByIdScreen();
			
		default:
			return new MainMenuScreen();
		}
	}
}
