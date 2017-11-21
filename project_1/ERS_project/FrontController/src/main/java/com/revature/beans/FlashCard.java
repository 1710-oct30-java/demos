package com.revature.beans;

public class FlashCard {
	private int flashCardId;
	private String question;
	private String answer;
	
	public FlashCard() {
		super();
	}
	
	public FlashCard(int flashCardId, String question, String answer) {
		super();
		this.flashCardId = flashCardId;
		this.question = question;
		this.answer = answer;
	}

	public int getFlashCardId() {
		return flashCardId;
	}

	public void setFlashCardId(int flashCardId) {
		this.flashCardId = flashCardId;
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

	@Override
	public String toString() {
		return "FlashCard [flashCardId=" + flashCardId + ", question=" + question + ", answer=" + answer + "]";
	}
	
	
	
}
