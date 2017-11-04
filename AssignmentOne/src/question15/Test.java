package question15;

public class Test
{
	public static void main(String[] args) {
		QuestionFifteen obj = new QuestionFifteen();
		int i = 10;
		int j = 5;
		
		System.out.println("10 + 5 = "+obj.add(i,j));
		System.out.println("10 - 5 = "+obj.subtract(i,j));
		System.out.println("10 * 5 = "+obj.multiplication(i, j));
		System.out.println("10 / 5 = "+obj.division(i, j));
}
	
}