package by.htp.ex.dao;

import java.sql.SQLException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.impl.connectionpool.ConnectionPoolException;

public interface IUserDAO  {	
	boolean logination(String login, String password) throws DaoException, SQLException, ConnectionPoolException;
	boolean loginExist(String login) throws DaoException, SQLException, ConnectionPoolException;
	boolean registration(NewUserInfo user) throws DaoException, SQLException, ConnectionPoolException;
	String getRole(String login, String password) throws DaoException, SQLException, ConnectionPoolException;
	boolean isAdmin(String login, String password) throws DaoException, SQLException, ConnectionPoolException;
}
