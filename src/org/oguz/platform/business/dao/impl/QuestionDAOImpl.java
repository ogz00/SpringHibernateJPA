package org.oguz.platform.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.oguz.platform.business.dao.IQuestionDAO;
import org.oguz.platform.business.model.impl.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDAOImpl implements IQuestionDAO
{
	private static final Logger logger = LoggerFactory.getLogger(QuestionDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}

	@Override
	public void addQuestion(Question q)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(q);
		logger.info("Question saved successfully, Question Details=" + q);

	}

	@Override
	public void updateQuestion(Question q)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(q);
		logger.info("Question updated successfully, Question Details=" + q);


	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> listQuestions()
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<Question> questionsList = session.createQuery("from question").list();
		for (Question q : questionsList)
		{
			logger.info("Question List::" + q);
		}
		return questionsList;
	}

	@Override
	public Question getQuestionById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Question q = (Question)session.load(Question.class, new Integer(id));
		logger.info("Question loaded successfully, Question details=" + q);
		return q;
	}

	@Override
	public void removeQuestion(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Question q = (Question)session.load(Question.class, new Integer(id));
		if (null != q)
		{
			session.delete(q);
		}
		logger.info("Question deleted successfully, Question details=" + q);
	}


	public int save(Question q)
	{
		Session session = sessionFactory.getCurrentSession();
		return (Integer)session.save(q);
	}

	@Override
	public void view(Question q)
	{
		Session session = sessionFactory.getCurrentSession();
		session.merge(q);
		logger.info("Question merged successfully, Question details=" + q);

	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Question> getQuestionsByExamId(int idExam)
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Question.class);

		cr.add(Restrictions.eq("exam", idExam));
		List<Question> questions = cr.list();
		for (Question q : questions)
		{
			logger.info("Question List By Exam::" + q);
		}

		return questions;

	}
	/*
	 * @SuppressWarnings("unchecked") public List<Answer> getAnswersByQuestion(int questionId) {
	 * Session session = this.sessionFactory.getCurrentSession(); Query query =
	 * session.createQuery("from answer where answer_id_question = :id"); query.setParameter("id",
	 * questionId); List<Answer> answersList = query.list();
	 * 
	 * return answersList; }
	 */


}
