package org.oguz.platform.business.model;


public interface IUser
{

	public abstract int getIdUser();

	public abstract void setIdUser(int idUser);

	public abstract String getFullname();

	public abstract void setFullname(String fullname);

	public abstract String getUsername();

	public abstract void setUsername(String username);

	public abstract String getPassword();

	public abstract void setPassword(String password);

}