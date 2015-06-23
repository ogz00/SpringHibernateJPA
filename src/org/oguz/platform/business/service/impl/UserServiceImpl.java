package org.oguz.platform.business.service.impl;

import java.util.List;

import org.oguz.platform.business.dao.IUserDAO;
import org.oguz.platform.business.model.impl.User;
import org.oguz.platform.business.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService
{
	private IUserDAO userDao;

	public void setUserDao(IUserDAO userDao)
	{
		this.userDao = userDao;
	}

	@Transactional
	@Override
	public void addUser(User u)
	{
		this.userDao.addUser(u);

	}

	@Transactional
	@Override
	public void updateUser(User u)
	{
		this.userDao.updateUser(u);

	}

	@Transactional
	@Override
	public List<User> listUsers()
	{
		return this.userDao.listUsers();
	}

	@Transactional
	@Override
	public User getUserById(int id)
	{
		return this.userDao.getUserById(id);
	}
	
	@Transactional
	@Override
	public void removeUser(int id)
	{
		this.userDao.removeUser(id);

	}

}
