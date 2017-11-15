package com.revature.beans;

public class FlashCard {
	private int flashCardId;
	private String question;
	private String answer;
	private int userId;

	public FlashCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlashCard(int flashCardId, String question, String answer, int userId) {
		super();
		this.flashCardId = flashCardId;
		this.question = question;
		this.answer = answer;
		this.userId = userId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + flashCardId;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlashCard other = (FlashCard) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (flashCardId != other.flashCardId)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlashCard [flashCardId=" + flashCardId + ", question=" + question + ", answer=" + answer + ", userId="
				+ userId + "]";
	}

}
