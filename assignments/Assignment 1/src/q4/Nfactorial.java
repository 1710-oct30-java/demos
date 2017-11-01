package q4;

public class Nfactorial {
	public static void main(String[] args) {
		int n = 10;
		int answer = 1;
		// just definition of a factorial
		for (int i = 1; i <= n; i++) {
			answer = answer * i;
		}
		System.out.println(answer);
	}
}
