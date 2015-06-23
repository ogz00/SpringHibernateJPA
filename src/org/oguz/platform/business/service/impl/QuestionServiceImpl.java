package org.oguz.platform.business.service.impl;

import java.util.List;

import org.oguz.platform.business.dao.IQuestionDAO;
import org.oguz.platform.business.model.IQuestion;
import org.oguz.platform.business.model.impl.Answer;
import org.oguz.platform.business.model.impl.Question;
import org.oguz.platform.business.service.IQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionServiceImpl implements IQuestionService
{
	private IQuestionDAO questionDao;

	public void setQuestionDao(IQuestionDAO questionDao)
	{
		this.questionDao = questionDao;
	}

	@Transactional
	@Override
	public void addQuestion(Question q)
	{
		this.questionDao.addQuestion(q);

	}

	@Transactional
	@Override
	public void updateQuestion(Question q)
	{
		this.questionDao.updateQuestion(q);

	}

	@Transactional
	@Override
	public List<Question> listQuestions()
	{
		return this.questionDao.listQuestions();
	}

	@Transactional
	@Override
	public Question getQuestionById(int id)
	{
		return this.questionDao.getQuestionById(id);
	}

	@Transactional
	@Override
	public void removeQuestion(int id)
	{
		questionDao.removeQuestion(id);

	}


	@Transactional
	@Override
	public int save(Question q)
	{
		return this.questionDao.save(q);
	}

	@Transactional
	@Override
	public void view(Question q)
	{
		this.questionDao.view(q);

	}

	@Override
	public List<Question> getQuestionsByExamId(int idExam)
	{
		return this.questionDao.getQuestionsByExamId(idExam);
	}

}
