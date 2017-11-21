package com.revature.screens;

import java.util.Scanner;

import com.revature.dao.FlashcardDAO;
import com.revature.dao.FlashcardDAOJdbc;

public class ViewFlashcardByIdScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private FlashcardDAO fcdao = new FlashcardDAOJdbc();
	@Override
	public Screen run() {
		System.out.println("Enter an integer");
		int input = Integer.parseInt(scan.nextLine());
		System.out.println(fcdao.findById(input));
		
		return new MainMenuScreen();
	}

}
