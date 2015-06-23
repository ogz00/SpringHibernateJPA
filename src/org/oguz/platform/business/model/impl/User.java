package org.oguz.platform.business.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.oguz.platform.business.model.IUser;


@Entity(name="user")
@Table(name="user")
public class User implements IUser
{
	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	@Column(name="full_name")
	private String fullname;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IUser#getIdUser()
	 */
	
	public int getIdUser()
	{
		return idUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IUser#setIdUser(int)
	 */
	
	public void setIdUser(int idUser)
	{
		this.idUser = idUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IUser#getFullname()
	 */
	
	public String getFullname()
	{
		return fullname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IUser#setFullname(java.lang.String)
	 */
	
	public void setFullname(String fullname)
	{
		this.fullname = fullname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IUser#getUsername()
	 */
	
	public String getUsername()
	{
		return username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IUser#setUsername(java.lang.String)
	 */
	
	public void setUsername(String username)
	{
		this.username = username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IUser#getPassword()
	 */
	
	public String getPassword()
	{
		return password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.oguz.platform.business.model.impl.IUser#setPassword(java.lang.String)
	 */
	
	public void setPassword(String password)
	{
		this.password = password;
	}

	
	public String toString()
	{
		return "User [idUser=" + idUser + ", fullname=" + fullname + ", username=" + username +
			", password=" + password + "]";
	}


}
