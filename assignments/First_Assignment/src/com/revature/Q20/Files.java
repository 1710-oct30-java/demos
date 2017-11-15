package com.revature.Q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Files {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("test.txt"));
			sc.useDelimiter(":");
			while(sc.hasNext()) {
				System.out.println("Name: " + sc.next() + " " + sc.next());
				System.out.println("Age: " + sc.next() + " years");
				System.out.println("State" + sc.nextLine() + " State");
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
