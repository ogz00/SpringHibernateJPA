package org.oguz.platform.business.service;

import java.util.List;

import org.oguz.platform.business.model.impl.User;

public interface IUserService
{
	public void addUser(User u);

	public void updateUser(User u);

	public List<User> listUsers();

	public User getUserById(int id);

	public void removeUser(int id);
}
