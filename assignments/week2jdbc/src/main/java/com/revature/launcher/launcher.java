package com.revature.launcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;
import com.revature.dao.FlashcardDAOJDBC;

public class launcher {
	
	private static Scanner scan = new Scanner(System.in);
	private static FlashcardDAO fcdao = new FlashcardDAOJDBC();
	public static void main(String[] args) {
//		List<Flashcard> fcList = new ArrayList<>();
//		Flashcard fc = new Flashcard();
//		System.out.println("Enter question");
//		fc.setQuestion(scan.nextLine());
//		System.out.println("Enter answer");
//		fc.setAnswer(scan.nextLine());
//		fcdao.preparedProcedureSave(fc);
//		fcList = fcdao.findall();
		System.out.println(fcdao.findById(1));
	}
}
