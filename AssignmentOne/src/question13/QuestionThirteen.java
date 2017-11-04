package question13;
/*
 * Display the triangle on the console as follows using any type of loop.
 * Do NOT use a simple group of print statements to accomplish this.
 * 0
 * 0 1
 * 0 1 0
 * 0 1 0 1
 */
public class QuestionThirteen 
{
	public static void main(String[] args) 
	{
		String str = "0101";
		
		for (int i = 1; i < 5; i++)
		{
			System.out.println(str.substring(0, i));			
		}
	}
	
}
