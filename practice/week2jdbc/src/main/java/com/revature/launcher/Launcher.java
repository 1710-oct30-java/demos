package com.revature.launcher;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;
import com.revature.dao.FlashcardDAOJdbc;

public class Launcher
{
	private static Scanner scan = new Scanner(System.in);
	private static FlashcardDAO fcdao = new FlashcardDAOJdbc();
	
	public static void main(String[] args)
	{
		Flashcard fc = new Flashcard();
		System.out.print("Enter question: ");
		fc.setQuestion(scan.nextLine());
		
		System.out.print("Enter answer: ");
		fc.setAnswer(scan.nextLine());
		
		fcdao.save(fc);
		//fcdao.betterSave(fc);
	}
}
