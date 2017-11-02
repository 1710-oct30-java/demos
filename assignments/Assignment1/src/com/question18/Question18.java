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
		Question18StrOps ops = new Question18StrOps("a");
		System.out.println(ops.hasCaps());
		System.out.println(ops.toCaps());
		try {
		System.out.println(ops.toIntAdd10());
		}catch (NumberFormatException e){
			//e.printStackTrace();
			System.out.println("Can't convert "+ "\"" +ops.getStr()+ "\""+" to an integer");
		}
	}
}
