package org.oguz.platform.business.model.impl;

import java.util.List;

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
import javax.persistence.Transient;

import org.oguz.platform.business.model.IExam;
import org.oguz.platform.business.model.IQuestion;

@Entity(name = "question")
@Table(name = "question")
public class Question implements IQuestion
{


	@Id
	@Column(name = "id_question")
	@SequenceGenerator(name = "seq_contacts", sequenceName = "seq_contacts")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_contacts")
	private int idQuestion;
	@Column(name = "question_text")
	private String questionText;
	@Column(name = "order_val")
	private int order;

	@Transient
	private List<String> answers;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id_exam", nullable = false)
	private Exam exam;

	public Question()
	{
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IQuestion#getIdQuestion()
	 */
	@Override
	public int getIdQuestion()
	{
		return idQuestion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IQuestion#setIdQuestion(int)
	 */
	@Override
	public void setIdQuestion(int idQuestion)
	{
		this.idQuestion = idQuestion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IQuestion#getQuestionText()
	 */
	@Override
	public String getQuestionText()
	{
		return questionText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IQuestion#setQuestionText(java.lang.String)
	 */
	@Override
	public void setQuestionText(String questionText)
	{
		this.questionText = questionText;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IQuestion#getOrder()
	 */
	@Override
	public int getOrder()
	{
		return order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IQuestion#setOrder(int)
	 */
	@Override
	public void setOrder(int order)
	{
		this.order = order;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IQuestion#getAnswers()
	 */
	@Override
	public List<String> getAnswers()
	{
		return answers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IQuestion#setAnswers(java.util.List)
	 */
	@Override
	public void setAnswers(List<String> answers)
	{
		this.answers = answers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IQuestion#getExam()
	 */
	@Override
	public Exam getExam()
	{
		return exam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.oguz.platform.business.model.impl.IQuestion#setExam(org.oguz.platform.business.model.
	 * IExam)
	 */
	@Override
	public void setExam(Exam exam)
	{
		this.exam = exam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IQuestion#toString()
	 */

	@Override
	public String toString()
	{
		return "Question [idQuestion=" + idQuestion + ", questionText=" + questionText +
			", order=" + order + ", answers=" + answers + ", exam=" + exam + "]";
	}


}
