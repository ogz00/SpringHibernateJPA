package org.oguz.platform.business.dao;

import java.util.List;

import org.oguz.platform.business.model.impl.User;

public interface IUserDAO
{
	
	public void addUser(User u);
    public void updateUser(User u);
    public List<User> listUsers();
    public User getUserById(int id);
    public void removeUser(int id);

}
