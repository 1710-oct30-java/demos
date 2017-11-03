package question4;

//write a program to compute n factorial

public class NFactorial {
	
	public static void main(String[] args) {
		int n = 7;
		int factor = n - 1;
		
		while(factor != 0) {
			n = n * factor;
			factor--;
		}
		System.out.println(n);
	}
	
}
