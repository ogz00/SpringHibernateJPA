package org.oguz.platform.business.model;

import java.util.Date;
import java.util.List;


public interface IExam
{

	public abstract int getIdExam();

	public abstract void setIdExam(int idExam);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract int getPassScore();

	public abstract void setPassScore(int passScore);

	public abstract int getTotalScore();

	public abstract void setTotalScore(int totalScore);

	public abstract Date getStartDate();

	public abstract void setStartDate(Date startDate);

	public abstract Date getEndDate();

	public abstract void setEndDate(Date endDate);

	public abstract List<String> getQuestions();

	public abstract void setQuestions(List<String> questions);

	public abstract List<String> getAnswers();

	public abstract void setAnswers(List<String> answers);

	public abstract void setStatus(String status);

	public abstract String getStatus();

	public abstract void setTrueAnswer(List<Boolean> trueAnswer);

	public abstract List<Boolean> getTrueAnswer();

}