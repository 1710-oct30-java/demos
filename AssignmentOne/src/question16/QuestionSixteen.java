package question16;
/*
 * Write a program to display the number of characters for a string
 * input. The string should be entered as a command line argument 
 * using (String[] args).
 */
public class QuestionSixteen 
{
	public static void main(String[] args) {
		for (String val:args)
		{
			System.out.println(val.length());
		}
	}
}
