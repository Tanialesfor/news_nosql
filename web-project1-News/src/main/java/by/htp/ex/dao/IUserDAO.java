package by.htp.ex.dao;

import java.sql.SQLException;

import by.htp.ex.bean.NewUserInfo;

public interface IUserDAO  {	
	boolean logination(String login, String password) throws DaoException, SQLException, ClassNotFoundException;
	boolean loginExist(String login) throws DaoException;
	boolean registration(NewUserInfo user) throws DaoException, SQLException, ClassNotFoundException;
	String getRole(String login, String password) throws DaoException, SQLException, ClassNotFoundException;
	boolean isAdmin(String login, String password) throws DaoException, SQLException, ClassNotFoundException;
}
