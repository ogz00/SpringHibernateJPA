package org.oguz.platform.business.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oguz.platform.business.dao.IUserDAO;
import org.oguz.platform.business.model.impl.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements IUserDAO
{
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}


	@Override
	public void addUser(User u)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		logger.info("User saved successfully, User Details=" + u);

	}

	@Override
	public void updateUser(User u)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		logger.info("User updated successfully, User Details=" + u);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers()
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from user").list();
		for (User u : usersList)
		{
			logger.info("User List::" + u);
		}
		return usersList;
	}

	@Override
	public User getUserById(int id)
	{

		Session session = this.sessionFactory.getCurrentSession();
		User u = (User)session.load(User.class, new Integer(id));
		logger.info("User loaded successfully, User details=" + u);
		return u;
	}

	@Override
	public void removeUser(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User)session.load(User.class, new Integer(id));
		if (null != u)
		{
			session.delete(u);
		}
		logger.info("User deleted successfully, user details=" + u);
	}


}
