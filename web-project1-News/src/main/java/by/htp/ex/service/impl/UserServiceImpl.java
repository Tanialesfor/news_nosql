package by.htp.ex.service.impl;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.service.ServiceException;
import by.htp.ex.util.validation.UserDataValidation;
import by.htp.ex.util.validation.ValidationProvider;
import by.htp.ex.service.IUserService;

public class UserServiceImpl implements IUserService{

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();
    private final UserDataValidation userDataValidation = ValidationProvider.getInstance().getUserDataValidation();
    
	
	@Override
	public String signIn(String login, String password) throws ServiceException {
				
		if(!userDataValidation.checkAUthData(login, password)) { 
			throw new ServiceException("login or password invalid"); 
		}
		 		
		try {
			if(userDAO.logination(login, password)) {
				return userDAO.getRole(login, password);
			}else {
				return "guest";
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public boolean registration(NewUserInfo user) throws ServiceException {
//		String name=user.getUserName();
//		String email=user.getEmail();
//		String login=user.getLogin();
//		String password=user.getPassword();
		
//		if (!userDataValidation.checkRegData(name, login, password, email)) {
//			throw new ServiceException("input field invalid");
//		}
		
		try {
			if (userDAO.registration(user)) {
				return true;
			} else {
				return false;
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean isAdmin(String login, String password) throws ServiceException {

		try {
			if (userDAO.isAdmin(login, password)==true) {
				return true;
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return false;
	}
}
