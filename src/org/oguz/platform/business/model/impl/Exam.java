package org.oguz.platform.business.model.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.oguz.platform.business.model.IExam;

@Entity(name = "exam")
@Table(name = "exam")
public class Exam implements IExam
{

	@Id
	@Column(name = "id_exam")
	@SequenceGenerator(name = "seq_contacts", sequenceName = "seq_contacts")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_contacts")
	private int idExam;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "pass_score")
	private int passScore;
	@Column(name = "total_score")
	private int totalScore;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "status")
	private String status;

	@Transient
	private List<String> questions;
	@Transient
	private List<String> answers;
	@Transient
	private List<Boolean> trueAnswer;

	public Exam()
	{
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#getIdExam()
	 */
	@Override
	public int getIdExam()
	{
		return idExam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#setIdExam(int)
	 */
	@Override
	public void setIdExam(int idExam)
	{
		this.idExam = idExam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#getName()
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#setName(java.lang.String)
	 */
	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#getDescription()
	 */
	@Override
	public String getDescription()
	{
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description)
	{
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#getPassScore()
	 */
	@Override
	public int getPassScore()
	{
		return passScore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#setPassScore(int)
	 */
	@Override
	public void setPassScore(int passScore)
	{
		this.passScore = passScore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#getTotalScore()
	 */
	@Override
	public int getTotalScore()
	{
		return totalScore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#setTotalScore(int)
	 */
	@Override
	public void setTotalScore(int totalScore)
	{
		this.totalScore = totalScore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#getStartDate()
	 */
	@Override
	public Date getStartDate()
	{
		return startDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#setStartDate(java.sql.Date)
	 */
	@Override
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#getEndDate()
	 */
	@Override
	public Date getEndDate()
	{
		return endDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#setEndDate(java.sql.Date)
	 */
	@Override
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#getStatus()
	 */
	@Override
	public String getStatus()
	{
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#setStatus(java.lang.String)
	 */
	@Override
	public void setStatus(String status)
	{
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#getQuestions()
	 */
	@Override
	public List<String> getQuestions()
	{
		return questions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#setQuestions(java.util.List)
	 */
	@Override
	public void setQuestions(List<String> questions)
	{
		this.questions = questions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#getAnswers()
	 */
	@Override
	public List<String> getAnswers()
	{
		return answers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IExam#setAnswers(java.util.List)
	 */
	@Override
	public void setAnswers(List<String> answers)
	{
		this.answers = answers;
	}

	@Override
	public List<Boolean> getTrueAnswer()
	{
		return trueAnswer;
	}
	
	@Override
	public void setTrueAnswer(List<Boolean> trueAnswer)
	{
		this.trueAnswer = trueAnswer;
	}

	@Override
	public String toString()
	{
		return "Exam [idExam=" + idExam + ", name=" + name + ", description=" + description +
			", passScore=" + passScore + ", totalScore=" + totalScore + ", startDate=" + startDate +
			", endDate=" + endDate + ", questions=" + questions + ", answers=" + answers + "]";
	}


}