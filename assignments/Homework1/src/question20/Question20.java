package question20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Read in from Data.txt and format the data to match the 
 */
public class Question20 {

	public static void main(String[] args) {
		// create an arrayList of people
		ArrayList<Person> peopleList = new ArrayList<>();
		String filename = "Data.txt";
		
		// read in the file and create a person for each line
		try {
			Scanner sc = new Scanner(new File(filename));
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] lineArray = line.split(":");
				Person newPerson = new Person(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]), lineArray[3]);
				
				// add the people to the list
				peopleList.add(newPerson);
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Print out the list to verify correctness
		for(Person ele: peopleList) {
			System.out.println(ele);
			System.out.println();
		}
	}
}