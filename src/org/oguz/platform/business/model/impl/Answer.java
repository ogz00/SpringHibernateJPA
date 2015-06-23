package org.oguz.platform.business.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.oguz.platform.business.model.IAnswer;
import org.oguz.platform.business.model.IQuestion;

@Entity(name = "answer")
@Table(name = "answer")
public class Answer implements IAnswer
{


	@Id
	@Column(name = "id_answer")
	@SequenceGenerator(name = "seq_contacts", sequenceName = "seq_contacts")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_contacts")
	private int idAnswer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "answer_id_question", nullable = false)
	private Question question;
	@Column(name = "sequence_no")
	private int sequenceNo;
	@Column(name = "answer_text")
	private String answerText;
	@Column(name = "flag_true_answer")
	private boolean trueAnswer;

	public Answer()
	{
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IAnswer#getIdAnswer()
	 */
	@Override
	public int getIdAnswer()
	{
		return idAnswer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IAnswer#setIdAnswer(int)
	 */
	@Override
	public void setIdAnswer(int idAnswer)
	{
		this.idAnswer = idAnswer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IAnswer#getQuestion()
	 */
	@Override
	public Question getQuestion()
	{
		return question;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.oguz.platform.business.model.impl.IAnswer#setQuestion(org.oguz.platform.business.model
	 * .IQuestion)
	 */
	@Override
	public void setQuestion(Question question)
	{
		this.question = question;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IAnswer#getSequenceNo()
	 */
	@Override
	public int getSequenceNo()
	{
		return sequenceNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IAnswer#setSequenceNo(int)
	 */
	@Override
	public void setSequenceNo(int sequenceNo)
	{
		this.sequenceNo = sequenceNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IAnswer#getAnswerText()
	 */
	@Override
	public String getAnswerText()
	{
		return answerText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IAnswer#setAnswerText(java.lang.String)
	 */
	@Override
	public void setAnswerText(String answerText)
	{
		this.answerText = answerText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IAnswer#isTrueAnswer()
	 */
	@Override
	public boolean isTrueAnswer()
	{
		return trueAnswer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IAnswer#setTrueAnswer(boolean)
	 */
	@Override
	public void setTrueAnswer(boolean trueAnswer)
	{
		this.trueAnswer = trueAnswer;
	}

	@Override
	public String toString()
	{
		return "Answer [idAnswer=" + idAnswer + ", question=" + question + ", sequenceNo=" +
			sequenceNo + ", answerText=" + answerText + ", trueAnswer=" + trueAnswer + "]";
	}


}