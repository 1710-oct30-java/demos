package homeworkOne;

public class NumberTwo {
	
	
	
	public static void main(String[] args)
	{
		int fibNumber = 26;
		
		for(int i = 0; i<fibNumber;i++)
		{
			System.out.print(fib(i) +" ");
		}
		
	}
	
	public static int fib(int fibNumber)
	{
		if( fibNumber == 0 || fibNumber == 1)
			return fibNumber;
		else
			return fib(fibNumber-1) + fib(fibNumber-2);
			
	}
	

}
