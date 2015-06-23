package org.oguz.platform.business.service.impl;

import java.util.List;

import org.oguz.platform.business.dao.IExamDAO;
import org.oguz.platform.business.dao.impl.ExamDAOImpl;
import org.oguz.platform.business.model.impl.Exam;
import org.oguz.platform.business.model.impl.Question;
import org.oguz.platform.business.service.IExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExamServiceImpl implements IExamService
{
	private IExamDAO examDao;

	public void setExamDao(IExamDAO examDao)
	{

		this.examDao = examDao;
	}

	@Transactional
	@Override
	public void addExam(Exam e)
	{
		this.examDao.addExam(e);

	}

	@Transactional
	@Override
	public void updateExam(Exam e)
	{
		this.examDao.updateExam(e);

	}

	@Transactional
	@Override
	public List<Exam> listExams()
	{
		return this.examDao.listExams();
	}

	@Transactional
	@Override
	public Exam getExamById(int id)
	{
		return this.examDao.getExamById(id);
	}

	@Transactional
	@Override
	public int save(Exam exam)
	{
		return this.examDao.save(exam);
	}

	@Transactional
	@Override
	public void view(Exam exam)
	{
		this.examDao.view(exam);

	}

	@Transactional
	@Override
	public void removeExam(int id)
	{
		this.examDao.removeExam(id);

	}


}
