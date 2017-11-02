package com.question18;

public class Question18
{
	public static void main(String[] args)
	{
		StringCalculator sc = new StringCalculator();
		String s1 = "this string has no caps.";
		String s2 = "This String Has Some Caps.";
		String s3 = "15";
		
		System.out.println(sc.hasCaps(s1));
		System.out.println(sc.hasCaps(s2));
		
		System.out.println(sc.allCaps(s2));
		
		System.out.println(sc.addTen(s3));
	}
}
