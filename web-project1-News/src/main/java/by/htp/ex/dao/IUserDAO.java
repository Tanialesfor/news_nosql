package by.htp.ex.dao;

import by.htp.ex.bean.NewUserInfo;

public interface IUserDAO {	
	boolean logination(String login, String password) throws DaoException;
	boolean loginExist(String login) throws DaoException;
	boolean registration(NewUserInfo user) throws DaoException;
	String getRole(String login, String password) throws DaoException;
	boolean isAdmin(String login, String password) throws DaoException;
}
