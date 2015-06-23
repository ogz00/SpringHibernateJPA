package org.oguz.platform.business.model;

import java.util.List;

import org.oguz.platform.business.model.impl.Exam;


public interface IQuestion
{

	public abstract int getIdQuestion();

	public abstract void setIdQuestion(int idQuestion);

	public abstract String getQuestionText();

	public abstract void setQuestionText(String questionText);

	public abstract int getOrder();

	public abstract void setOrder(int order);

	public abstract List<String> getAnswers();

	public abstract void setAnswers(List<String> answers);

	public abstract Exam getExam();

	public abstract void setExam(Exam exam);

	public abstract String toString();

}