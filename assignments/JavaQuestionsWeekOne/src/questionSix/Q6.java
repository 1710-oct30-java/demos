package questionSix;

public class Q6 {

	//Write a program to determine if an integer is even without using %.
	
	public static void main(String[] args) {
		System.out.println(evenCheck(5));
		System.out.println(evenCheck(4));
	}
	
	public static boolean evenCheck(int i) {
		//Integers will discard any remainder when dividing.
		//By multiplying the divided number, we can check if anything was discarded.
		
		int divided = i/2;
		
		if (divided * 2 == i) return true;
		else return false;
	}

}
