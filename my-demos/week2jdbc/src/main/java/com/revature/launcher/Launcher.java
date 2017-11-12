package com.revature.launcher;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;
import com.revature.dao.FlashcardDAOJdbc;
import com.revature.screens.MainMenuScreen;
import com.revature.screens.Screen;

public class Launcher {
	public static void main(String[] args) {
		Screen currentScreen = new MainMenuScreen();
		while(true) {
			currentScreen = currentScreen.run();
		}
	}
}
