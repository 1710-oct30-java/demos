package com.homeworkOne.problemFifteen;

public class ProblemFifteen implements ProblemFifteenInterface {
//Class to implement Interface
	
	public ProblemFifteen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int addition(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	@Override
	public int subtraction(int x, int y) {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public int multiplication(int x, int y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	@Override
	public double division(int x, int y) {
		// TODO Auto-generated method stub
		if(y>0)
		{
			return x/y;
		}
		else
		{	
			System.out.println("Division by 0");
			return 0;
		}
	}


}
