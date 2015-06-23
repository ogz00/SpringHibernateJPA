package org.oguz.platform.business.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oguz.platform.business.dao.IAnswerDAO;
import org.oguz.platform.business.model.impl.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnswerDAOImpl implements IAnswerDAO
{

	private static final Logger logger = LoggerFactory.getLogger(AnswerDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}

	@Override
	public void addAnswer(Answer a)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(a);
		logger.info("Answer saved successfully, Answer Details=" + a);

	}

	@Override
	public void updateAnswer(Answer a)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(a);
		logger.info("Answer updated successfully, Answer Details=" + a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> listAnswers()
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<Answer> answersList = session.createQuery("from answer").list();
		for (Answer a : answersList)
		{
			logger.info("Answer List::" + a);
		}
		return answersList;
	}

	
	
	public int removeAnswerFromQuestion(int answerId)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("update answer set answer_id_question = :id"
			+ " where id_answer = :answerId");
		query.setParameter("id", 0);
		query.setParameter("answerid", answerId);

		int result = query.executeUpdate();
		
		return result;
	}

	@Override
	public Answer getAnswerById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Answer a = (Answer)session.load(Answer.class, new Integer(id));
		logger.info("Answer loaded successfully, Answer details= " + a);
		return a;
		
	}

	@Override
	public void view(Answer a)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(a);
		logger.info("Answer merged successfully, Answer details= " + a);
	}

	@Override
	public void deleteAnswer(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Answer a = (Answer)session.load(Answer.class, new Integer(id));
		if (null != a)
		{
			session.delete(a);
		}
		logger.info("Answer deleted successfully, Answer details=" + a);
		
	}

	@Override
	public int save(Answer a)
	{
		Session session = this.sessionFactory.getCurrentSession();
		return (Integer)session.save(a);
	}
	


}
