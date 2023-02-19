package by.htp.ex.service;

import java.sql.SQLException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.impl.connectionpool.ConnectionPoolException;

public interface IUserService {
	
	String signIn(String login, String password) throws ServiceException;
	boolean isAdmin(String login, String password) throws ServiceException;
	boolean registration(NewUserInfo user) throws ServiceException;
}
