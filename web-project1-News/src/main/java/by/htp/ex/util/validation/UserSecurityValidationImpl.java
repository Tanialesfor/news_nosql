package by.htp.ex.util.validation;

import jakarta.servlet.http.HttpSession;

public class UserSecurityValidationImpl implements UserSecurityValidation{
	@Override
	public boolean isAdminRole(HttpSession session) {
		if (session != null) {
			return (boolean) session.getAttribute("isAdminRole");
		}
		return false;
	}	
}
