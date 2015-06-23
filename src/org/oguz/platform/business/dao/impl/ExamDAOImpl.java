package org.oguz.platform.business.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oguz.platform.business.dao.IExamDAO;
import org.oguz.platform.business.model.impl.Exam;
import org.oguz.platform.business.model.impl.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ExamDAOImpl implements IExamDAO
{
	private static final Logger logger = LoggerFactory.getLogger(ExamDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}


	@Override
	public void addExam(Exam e)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
		logger.info("Exam saved successfully, Exam Details=" + e);

	}

	@Override
	public void updateExam(Exam e)
	{
		Session session = this.sessionFactory.getCurrentSession();
		// session.update
		session.merge(e);
		logger.info("Exam updated successfully, Exam Details=" + e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Exam> listExams()
	{
		Session session = this.sessionFactory.getCurrentSession();

		List<Exam> examList = session.createQuery("from exam").list();
		for (Exam e : examList)
		{
			logger.info("Exam List::" + e);
		}
		return examList;
	}

	@Override
	public Exam getExamById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Exam e = (Exam)session.load(Exam.class, new Integer(id));
		logger.info("Exam loaded successfully, Exam details=" + e);
		return e;
	}

	@Override
	public void removeExam(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Exam e = (Exam)session.load(Exam.class, new Integer(id));
		if (null != e)
		{
			session.delete(e);
		}
		logger.info("Exam deleted successfully, Exam details=" + e);

	}


	@Override
	public int save(Exam exam)
	{
		Session session = this.sessionFactory.getCurrentSession();
		return (Integer)session.save(exam);
	}


	@Override
	public void view(Exam exam)
	{
		Session session = this.sessionFactory.getCurrentSession();

		session.merge(exam);

	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<Question> setQuestionsToExam(int examId) { Session session =
	 * this.sessionFactory.getCurrentSession(); Query query =
	 * session.createQuery("from question where question_id_exam = :id"); query.setParameter("id",
	 * examId); List<Question> questionList = query.list(); return questionList; }
	 */


}
