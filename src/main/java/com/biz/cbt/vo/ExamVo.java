package com.biz.cbt.vo;

public class ExamVo {
	
	private String id;
	private String question;
	private String anwer;
	private String exam;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnwer() {
		return anwer;
	}
	public void setAnwer(String anwer) {
		this.anwer = anwer;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	@Override
	public String toString() {
		return "ExaVo [id=" + id + ", question=" + question + ", anwer=" + anwer + ", exam=" + exam + "]";
	}
	public ExamVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamVo(String id, String question, String anwer, String exam) {
		super();
		this.id = id;
		this.question = question;
		this.anwer = anwer;
		this.exam = exam;
	}
	public ExamVo(String question, String anwer, String exam) {
		super();
		this.question = question;
		this.anwer = anwer;
		this.exam = exam;
	}
	
	

}
