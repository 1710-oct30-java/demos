package com.question18;

public abstract class Question18Strings
{
	private String str;
	
	
	public Question18Strings()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Question18Strings(String str)
	{
		super();
		this.str = str;
	}
	
	public String getStr()
	{
		return str;
	}

	public void setStr(String str)
	{
		this.str = str;
	}

	public abstract boolean hasCaps();
	public abstract String toCaps();
	public abstract int toIntAdd10();
}
