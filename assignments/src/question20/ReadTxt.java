package question20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Create a notepad file called Data.txt and enter the follow:
 * 
 * Mickey:Mouse:35:Arizona
 * Hulk:Hoga:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * 
 * Write a program that would read from the file and print it out to the screen 
 * in the following format:
 * 
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona
 * 
 * @author Mitch Goshorn
 *
 */
public class ReadTxt {
	
	private static final String FILE_LOCATION = "/Data.txt";
	
	private String name;
	private int age;
	private String state;
	
	public ReadTxt(String name, int age, String state) {
		super();
		this.name = name;
		this.age = age;
		this.state = state;
	}
	
	public String toString() {
		String string = String.format("Name: %s%nAge: %d years%nState: %s State", name, age, state);
		return string;
	}
	
	public static void main(String[] args) throws IOException {
		//Get the full path 
		String string = Paths.get("").toAbsolutePath().toString() + FILE_LOCATION;

		//Read lines of file into List
		List<String> strings = Files.readAllLines(Paths.get(string));
		
		
		//Iterate through each line, create object for it, output object as string
		for(String str : strings) {
			//split string at colons
			String[] strArr = str.split(":");
			
			//process array 
			String 	name  = strArr[0] + " " + strArr[1];
			int 	age   = Integer.valueOf(strArr[2]);
			String 	state = strArr[3];
			
			//Create object
			ReadTxt line = new ReadTxt(name, age, state);
			
			//output object as string
			System.out.println(line);
			System.out.println();
		}
	}
	
	
}
