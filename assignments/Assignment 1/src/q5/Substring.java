package q5;

public class Substring {

	public String subString(String s, int idx) {
		// build a string from first idx-1 characters
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < idx - 1; i++) {
			answer.append(s.charAt(i));
		}
		return answer.toString();

	}

	public static void main(String[] args) {
		String s = "Hello";
		int idx = 3;
		Substring firstThree = new Substring();
		System.out.println(firstThree.subString(s, idx));

	}
}
