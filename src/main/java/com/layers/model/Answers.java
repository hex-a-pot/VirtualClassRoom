package com.layers.model;

public class Answers {
	private long doubtId;
	private String answer;

	Answers() {
		super();
	}

	public Answers(long doubtId, String answer) {
		this.doubtId = doubtId;
		this.answer = answer;
	}
	public Answers(String answer) {
		this.answer = answer;
	}

	public long getDoubtId() {
		return doubtId;
	}

	public void setDoubtId(long doubtId) {
		this.doubtId = doubtId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

}
