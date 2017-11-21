package com.revature.beans;

public class Flashcard {
	private int flashCardID;
	private String question;
	private String answer;
	private int userID;
	
	public Flashcard() {
		super();
	}
	public int getFlashCardID() {
		return flashCardID;
	}
	public void setFlashCardID(int flashCardID) {
		this.flashCardID = flashCardID;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
