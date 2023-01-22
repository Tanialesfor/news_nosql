package by.htp.ex.util.validation;

import jakarta.servlet.http.HttpSession;

public interface UserSecurityValidation {
	boolean isAdminRole(HttpSession session);     
}
