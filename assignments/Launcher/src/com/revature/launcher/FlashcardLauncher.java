package com.revature.launcher;

import java.util.Scanner;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;
import com.revature.dao1.FlashcardDAOJdbc;

public class FlashcardLauncher {
	private static Scanner scan = new Scanner(System.in;
	private static FlashcardDAO fcdao = new FlashcardDAOJdbc();
	
	public static void main(String[] args) {
		Flashcard fc = new Flashcard();
		
		System.out.println(fcdao.findAll());
		
	}
}
