package by.htp.ex.util.validation;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;

public class UserDataValidationImpl implements UserDataValidation{

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();
	
	@Override
	public boolean checkAUthData(String login, String password) {
		try {
			if (userDAO.logination(login, password)==true) {
				return true;
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
