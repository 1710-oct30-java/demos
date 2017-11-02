package com.revature.strings;

public class Strings {
	public static void main(String[] args) {
		String str = "hello";
		String str2 = "     hello    ";
		str2 = str2.trim().intern();
		System.out.println(str2);
		compare(str, str2);
		
		String str3 = new String("hello");
		compare(str, str3);
		
		String str4 = "el";
		compare(str4, str.substring(1, 3));
		
//		String[] str5 = str.split("");
//		for(String ele: str5) {
//			System.out.println(ele);
//		}
		
	}
	
	private static void compare(String one, String two) {
		if(one == two) {
			System.out.println("strings are the exact same string in memory");
		} else {
			if(one.equals(two)) {
				System.out.println("strings are equivalent but not the same in memory");
			} else {
				System.out.println("strings are not at all equivalent");
			}
		}
	}
}
