package com.revature.beans;

public class Flashcard
{
	private int id;
	private String question;
	private String answer;
	
	
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getQuestion()
	{
		return question;
	}
	public void setQuestion(String question)
	{
		this.question = question;
	}
	public String getAnswer()
	{
		return answer;
	}
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	@Override
	public String toString()
	{
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}
	
	
}
