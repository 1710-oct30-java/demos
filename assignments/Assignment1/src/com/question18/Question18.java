package com.question18;
/*
 * check uppercase in string
 * convert string to uppercase
 * convert string to integer add 10
 */

public class Question18
{
	public static void main(String[] args)
	{
		Question18StrOps ops = new Question18StrOps("10");
		System.out.println(ops.hasCaps());
		System.out.println(ops.toCaps());
		System.out.println(ops.toIntAdd10());
		
	}
}
