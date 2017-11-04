package question20;
/*
 * Create a notepad file called Data.txt and enter the following:
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * Write a program that would read from the file and print it out to 
 * the screen in the following format:
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona State
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionTwenty 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File filename = new File("C:\\Users\\Brandon.Brandon-PC\\Desktop\\Data.txt");
		Scanner s = new Scanner(filename);
		
		s.useDelimiter(":");
		System.out.println("Name: "+s.next()+" "+s.next());
		System.out.println("Age: "+s.next()+" years");
		System.out.println("State: "+s.findInLine("Arizona")+ " State");
		s.close();
	}
	
}
