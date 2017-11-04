package question5;
/*
 * Write a substring method that accepts a string str and an integer 
 * idx and returns the substring contained between 0 and idx-1 inclusive
 * Do NOT use any of the existing substring methods in the String,
 * StringBuilder, or StringBuffer APIs
 */
public class QuestionFive 
{
	public static void main(String[] args) 
	{
	String str = "hello";
	int idx = 3;
	
	substring(str, idx);
	}
	//prints the substring contained between 0 and idx-1 inclusive
	public static void substring(String str, int index)
	{
		char[] arr = str.toCharArray();
		for (int i=0;i<=index-1;i++)
		{
			System.out.print(arr[i]);
		}
	}
}
