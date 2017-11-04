package question19;
import java.util.ArrayList;
public class List {
	//Robert Choboy- Revature
    //This is a program that will create an array. Once the array is created, 3 thing will be produced:
	//The Sum of the even numbers of the Array, The sum of the odd numbers, and prime numbers will be removed 
	
		public static void main(String[] args)
		{
			ArrayList<Integer> array = new ArrayList<Integer>();
			
			for(int i = 1; i <= 10; i++)
				array.add(i);
			
			System.out.println("The array list: " + array);
			int even = 0;
			int odd = 0;
			// Add the even then Add The odd Number. After, remove the prime numbers and print the list of Array
			// without prime numbers
			for(int i = 0; i < array.size(); i++ )
			{
				Integer num = array.get(i);
				
				if( num % 2 == 0 )
					even = even + num;
				if( num % 2 == 1  )
					odd = odd + num;
				
				
				if( checkPrime(num) )
				{		
					//Remove numbers from array that are prime
					array.remove(i);
					//Decrement
					i--;
						}
		
			}	       
		}
		private static boolean checkPrime(Integer i) {
			
			{
				for (int n = 2; n<i; n++){
					if (i%n==0) 
						
						return false;
					
				}
				        
				        return true;
		}
	}

}



