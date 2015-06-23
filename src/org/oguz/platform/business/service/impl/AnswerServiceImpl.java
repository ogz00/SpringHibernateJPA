package org.oguz.platform.business.service.impl;

import java.util.List;

import org.oguz.platform.business.dao.IAnswerDAO;
import org.oguz.platform.business.model.IAnswer;
import org.oguz.platform.business.model.impl.Answer;
import org.oguz.platform.business.service.IAnswerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnswerServiceImpl implements IAnswerService
{
	private IAnswerDAO answerDao;

	public void setAnswerDao(IAnswerDAO answerDao)
	{

		this.answerDao = answerDao;
	}

	@Transactional
	@Override
	public void addAnswer(Answer a)
	{
		this.answerDao.addAnswer(a);

	}

	@Transactional
	@Override
	public void updateAnswer(Answer a)
	{
		this.answerDao.updateAnswer(a);

	}

	@Transactional
	@Override
	public List<Answer> listAnswers()
	{
		return this.answerDao.listAnswers();
	}


	@Transactional
	@Override
	public Answer getAnswerById(int id)
	{
		return this.answerDao.getAnswerById(id);
	}

	@Transactional
	@Override
	public void view(Answer a)
	{
		this.answerDao.view(a);

	}

	@Transactional
	@Override
	public void deleteAnswer(int id)
	{
		this.answerDao.deleteAnswer(id);

	}

	@Transactional
	@Override
	public int save(Answer a)
	{
		return this.answerDao.save(a);
	}


}
