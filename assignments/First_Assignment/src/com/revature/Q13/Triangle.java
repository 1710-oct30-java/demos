package com.revature.Q13;

public class Triangle {
	public static void main(String[] args) {
		String str = "0";
		for (int i = 0; i < 4; i++) {
			
			if(str.charAt(0) == '0' && str.charAt(str.length()-1) == '0') {
				System.out.println(str);
				str = '1' + str;
			}
			else if (str.charAt(0) == '1' && str.charAt(str.length()-1) == '0') {
				System.out.println(str);
				str = str + '1';
			}
			else if(str.charAt(0) == '1' && str.charAt(str.length()-1) == '1' ) {
				System.out.println(str);
				str = '0' + str;
			}
			else {
				System.out.println(str);
			}
			
		}
	}
}
