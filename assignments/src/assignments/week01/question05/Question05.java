package assignments.week01.question05;

public class Question05 {
	public static void main(String[] args) {
		/*
		 * generating test data string
		 */
		String data = "abcdefghijklmnopqrstuvwxyz";
		
		System.out.println( firstNCharacters(data, 8) );
	}
	
	/**
	 * return the first N characters without
	 * using any substring API's
	 * 
	 * @param String s
	 * @param int count
	 * 
	 * @return String
	 */
	public static String firstNCharacters(String s, int count)
	{
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < count; i++  ) {
			sb.append( s.charAt(i) );
		}
		
		return String.valueOf( sb );
	}
}
