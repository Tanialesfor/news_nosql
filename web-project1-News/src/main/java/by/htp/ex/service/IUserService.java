package by.htp.ex.service;

import java.sql.SQLException;

import by.htp.ex.bean.NewUserInfo;

public interface IUserService {
	
	String signIn(String login, String password) throws ServiceException, SQLException, ClassNotFoundException;
	boolean isAdmin(String login, String password) throws ServiceException;
	boolean registration(NewUserInfo user) throws ServiceException;
}
