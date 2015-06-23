package org.oguz.platform.business.dao;

import java.util.List;

import org.oguz.platform.business.model.impl.Answer;


public interface IAnswerDAO
{
	public void addAnswer(Answer a);

	public void updateAnswer(Answer a);

	public Answer getAnswerById(int id);

	public List<Answer> listAnswers();

	public void view(Answer a);

	public void deleteAnswer(int id);
	
	public int save(Answer a);  

}
