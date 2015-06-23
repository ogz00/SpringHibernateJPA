package org.oguz.platform.business.model.impl;

import java.util.ArrayList;

import org.oguz.platform.business.model.IAnsweredQuestion;
import org.springframework.stereotype.Component;

public class AnsweredQuestion implements IAnsweredQuestion
{
	private int questionNumber;
	private String questionText;
	private ArrayList<Answer> answers = new ArrayList<Answer>();
	private int correctAnswer;
	private int userAnswer;

	public AnsweredQuestion()
	{

	}

	public AnsweredQuestion(int questionNumber, String questionText, ArrayList<Answer> answers,
		int correctAnswer, int userAnswer)
	{
		this.questionNumber = questionNumber;
		this.questionText = questionText;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
		this.userAnswer = userAnswer;
	}

	/* (non-Javadoc)
	 * @see org.oguz.platform.business.model.impl.IAnsweredQuestion#getQuestionNumber()
	 */
	@Override
	public int getQuestionNumber()
	{
		return questionNumber;
	}

	/* (non-Javadoc)
	 * @see org.oguz.platform.business.model.impl.IAnsweredQuestion#setQuestionNumber(int)
	 */
	@Override
	public void setQuestionNumber(int questionNumber)
	{
		this.questionNumber = questionNumber;
	}

	/* (non-Javadoc)
	 * @see org.oguz.platform.business.model.impl.IAnsweredQuestion#getQuestionText()
	 */
	@Override
	public String getQuestionText()
	{
		return questionText;
	}

	/* (non-Javadoc)
	 * @see org.oguz.platform.business.model.impl.IAnsweredQuestion#setQuestionText(java.lang.String)
	 */
	@Override
	public void setQuestionText(String questionText)
	{
		this.questionText = questionText;
	}

	/* (non-Javadoc)
	 * @see org.oguz.platform.business.model.impl.IAnsweredQuestion#getAnswers()
	 */
	@Override
	public ArrayList<Answer> getAnswers()
	{
		return answers;
	}

	/* (non-Javadoc)
	 * @see org.oguz.platform.business.model.impl.IAnsweredQuestion#setAnswers(java.util.ArrayList)
	 */
	@Override
	public void setAnswers(ArrayList<Answer> answers)
	{
		this.answers = answers;
	}

	/* (non-Javadoc)
	 * @see org.oguz.platform.business.model.impl.IAnsweredQuestion#getCorrectAnswer()
	 */
	@Override
	public int getCorrectAnswer()
	{
		return correctAnswer;
	}

	/* (non-Javadoc)
	 * @see org.oguz.platform.business.model.impl.IAnsweredQuestion#setCorrectAnswer(int)
	 */
	@Override
	public void setCorrectAnswer(int correctAnswer)
	{
		this.correctAnswer = correctAnswer;
	}

	/* (non-Javadoc)
	 * @see org.oguz.platform.business.model.impl.IAnsweredQuestion#getUserAnswer()
	 */
	@Override
	public int getUserAnswer()
	{
		return userAnswer;
	}

	/* (non-Javadoc)
	 * @see org.oguz.platform.business.model.impl.IAnsweredQuestion#setUserAnswer(int)
	 */
	@Override
	public void setUserAnswer(int userAnswer)
	{
		this.userAnswer = userAnswer;
	}


}
