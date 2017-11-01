package com.question18;

public class Question18StrOps extends Question18Strings
{

	public Question18StrOps()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Question18StrOps(String str)
	{
		super(str);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean hasCaps()
	{
		for (int i =0; i < getStr().length(); i++)
		{
			if(Character.isUpperCase(getStr().charAt(i)))
				return true;
		}
		return false;
	}
	
	@Override
	public String toCaps()
	{
		return getStr().toUpperCase();
	}
	
	@Override
	public int toIntAdd10()
	{
		return Integer.parseInt(getStr()) +10;
	}
}
