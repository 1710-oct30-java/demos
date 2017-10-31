package homeworkOne;

public class NumberTwo {
	
	
	
	public static void main(String[] args)
	{
		int fibNumber = 25;
		
		System.out.print(fib(fibNumber) +" ");
		
	}
	
	public static int fib(int fibNumber)
	{
		if(fibNumber == 0)
			return 0;
		else if( fibNumber == 1 || fibNumber == 2)
			return 1;
		else
			return fib(fibNumber-1) + fib(fibNumber-2);
			
	}
	public static int fibCounter(int fibNumber)
	{
		return 1;
	}
	

}
