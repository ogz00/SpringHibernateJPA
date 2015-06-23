package org.oguz.platform.business.service;

import java.util.List;

import org.oguz.platform.business.model.IAnswer;
import org.oguz.platform.business.model.impl.Answer;

public interface IAnswerService
{
	public void addAnswer(Answer a);

	public void updateAnswer(Answer a);

	public Answer getAnswerById(int id);

	public List<Answer> listAnswers();

	public void view(Answer a);

	public void deleteAnswer(int id);
	
	public int save(Answer a);  
}
