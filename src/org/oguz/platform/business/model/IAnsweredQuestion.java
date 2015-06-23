package org.oguz.platform.business.model;

import java.util.ArrayList;

import org.oguz.platform.business.model.impl.Answer;


public interface IAnsweredQuestion
{

	public abstract int getQuestionNumber();

	public abstract void setQuestionNumber(int questionNumber);

	public abstract String getQuestionText();

	public abstract void setQuestionText(String questionText);

	public abstract ArrayList<Answer> getAnswers();

	public abstract void setAnswers(ArrayList<Answer> answers);

	public abstract int getCorrectAnswer();

	public abstract void setCorrectAnswer(int correctAnswer);

	public abstract int getUserAnswer();

	public abstract void setUserAnswer(int userAnswer);

}