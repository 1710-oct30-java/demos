package com.question11;
import com.question09.Question11FloatA;
import com.question10.Question11FloatB;
/*
 * access float from different packages
 */
public class Question11
{
	public static void main(String[] args)
	{
		Question11FloatA a = new Question11FloatA();
		Question11FloatB b = new Question11FloatB();
		
		System.out.println(a.a);
		System.out.println(b.b);
	}
}
