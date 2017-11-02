package assignments.week01.question14;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Question14 
{
	public static void main(String[] args) 
	{
		String selection = ( args.length > 0 ) ? args[0] : "";
		
		switch( selection ) {
			case "1" :
				System.out.println( Math.sqrt( 244.0 ));
				break;
			case "2" :
				System.out.println( LocalDateTime.now().format( DateTimeFormatter.ISO_DATE) );
				break;
			default :
				String input = "I am learning Core Java";
				String[] parts = input.split("");
				System.out.println( Arrays.toString( parts ) );
				break;
		}
	}

}
