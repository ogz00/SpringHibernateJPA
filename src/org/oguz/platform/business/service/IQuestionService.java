package org.oguz.platform.business.service;

import java.util.List;

import org.oguz.platform.business.model.IQuestion;
import org.oguz.platform.business.model.impl.Answer;
import org.oguz.platform.business.model.impl.Question;


public interface IQuestionService
{
	public void addQuestion(Question q);

	public void updateQuestion(Question q);

	public Question getQuestionById(int id);

	public int save(Question question);

	public List<Question> listQuestions();

	public void removeQuestion(int id);

	public void view(Question q);

	public List<Question> getQuestionsByExamId(int idExam);


}
