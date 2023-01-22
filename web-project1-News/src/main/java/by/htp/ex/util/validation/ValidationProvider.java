package by.htp.ex.util.validation;


public class ValidationProvider {
	private static final ValidationProvider instance = new ValidationProvider();

	private final UserDataValidation userDataValidation = new UserDataValidationImpl();
	private final UserSecurityValidation userSecurityValidation = new UserSecurityValidationImpl();
		
	private ValidationProvider() {
	}
		
	public UserDataValidation getUserDataValidation() {
		return userDataValidation;
	}
	
	public UserSecurityValidation getUserSecurityValidation() {
		return userSecurityValidation;
	}	
		
	public static ValidationProvider getInstance() {
		return instance;
	}
}
