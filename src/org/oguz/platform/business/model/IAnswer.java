package org.oguz.platform.business.model;

import org.oguz.platform.business.model.impl.Question;



public interface IAnswer
{

	public abstract int getIdAnswer();

	public abstract void setIdAnswer(int idAnswer);

	public abstract Question getQuestion();

	public abstract void setQuestion(Question question);

	public abstract int getSequenceNo();

	public abstract void setSequenceNo(int sequenceNo);

	public abstract String getAnswerText();

	public abstract void setAnswerText(String answerText);

	public abstract boolean isTrueAnswer();

	public abstract void setTrueAnswer(boolean trueAnswer);

}