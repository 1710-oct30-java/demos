package com.revature.launcher;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.revature.utility.FileUtil;

public class FileLauncher {
	private static FileUtil fUtil = new FileUtil();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		fUtil.writeByte(111111111);
		for (int i = 0; i < 15; i++) {
			System.out.println(fUtil.readByte());
		}

		fUtil.writeChar("char");
		System.out.println(fUtil.readChar());

		// fUtil.writeLine("hello world!");
		System.out.println(fUtil.readLine(2));

		System.out.println("enter username: ");
		String username = scan.nextLine();
		System.out.println("username entered was: " + username);

		System.out.println("enter a number: ");
		String num = scan.nextLine();
		try {
			Integer.parseInt(num);
		} catch (NumberFormatException e) {
			System.out.println("invalid input");
		}

		System.out.println("number entered: " + num);

		System.out.println("whole file");
		List<String> file = fUtil.readWholeFile();
		System.out.println(file);

	}
}
