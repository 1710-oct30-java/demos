package q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MickeyMouse {
	public static void main(String[] args) throws IOException {
		// read text file
		FileReader in = new FileReader("Data.txt");
		BufferedReader br = new BufferedReader(in);
		Scanner sc = new Scanner(br);

		// split each line by delimiter ":" and add each word to arraylist
		List<String> CharList = new ArrayList<String>();

		while (sc.hasNextLine()) {
			CharList.addAll(Arrays.asList(sc.nextLine().split(":")));
		}
		sc.close();

		// print out name, age, state
		for (int i = 0; i < CharList.size(); i = i + 4) {
			System.out.println("Name: " + CharList.get(i) + " " + CharList.get(i + 1));
			System.out.println("Age: " + CharList.get(i + 2) + " years");
			System.out.println("State: " + CharList.get(i + 3) + " State");
			System.out.println("");
		}

	}
}
