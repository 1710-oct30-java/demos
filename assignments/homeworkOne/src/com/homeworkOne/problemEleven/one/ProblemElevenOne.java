package com.homeworkOne.problemEleven.one;
//Second package for problem eleven
public class ProblemElevenOne {
	private int var1;
	private int var2;
	@Override
	public String toString() {
		return "ProblemElevenOne [var1=" + var1 + ", var2=" + var2 + "]";
	}
	public int getVar1() {
		return var1;
	}
	public void setVar1(int var1) {
		this.var1 = var1;
	}
	public int getVar2() {
		return var2;
	}
	public void setVar2(int var2) {
		this.var2 = var2;
	}
	public ProblemElevenOne(int var1, int var2) {
		super();
		this.var1 = var1;
		this.var2 = var2;
	}
	public ProblemElevenOne() {
		super();
		// TODO Auto-generated constructor stub
	}
}
