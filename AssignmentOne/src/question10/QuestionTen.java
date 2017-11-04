package question10;
/*
 * Find the minimum of two numbers using ternary operators.
 */
public class QuestionTen 
{
	public static void main(String[] args) 
	{	
	int a = 5;
	int b = 10;
	
	int minimum = (a < b) ? a : b;
	
	System.out.println(minimum+" is the minimum of the values 5 and 10.");
	}
}
