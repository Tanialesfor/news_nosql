package by.htp.ex.util.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;

public class UserDataValidationImpl implements UserDataValidation{

    private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();
	
	private static final String LOGIN_PATTERN_REG = "^[a-zA-Z0-9]{1,10}$";
	private static final String PASSWORD_PATTERN_REG = "^[a-zA-Z0-9]{1,10}$";
	private static final String EMAIL_PATTERN_REG = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final Pattern LOGIN_PATTERN = Pattern.compile(LOGIN_PATTERN_REG);
	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_PATTERN_REG);
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_PATTERN_REG);
	
	@Override
	public boolean checkAUthData(String login, String password) {
		Matcher loginMatcher = LOGIN_PATTERN.matcher(login);
		Matcher passwordMatcher=PASSWORD_PATTERN.matcher(password);
		return loginMatcher.matches()&passwordMatcher.matches();			
	}	
		
	@Override
	public boolean checkRegData(String login, String password, String email) {
		Matcher loginMatcher = LOGIN_PATTERN.matcher(login);
		Matcher passwordMatcher=PASSWORD_PATTERN.matcher(password);
		Matcher emailMatcher=EMAIL_PATTERN.matcher(email);
		return loginMatcher.matches()&passwordMatcher.matches()&emailMatcher.matches();
	}
		
}
