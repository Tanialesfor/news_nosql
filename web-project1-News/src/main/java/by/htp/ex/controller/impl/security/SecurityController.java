package by.htp.ex.controller.impl.security;

import jakarta.servlet.http.HttpSession;

public class SecurityController {
	public static boolean isAdminRole(HttpSession session) {
		if (session != null) {
			return (boolean) session.getAttribute("isAdminRole");
		}
		return false;
	}	
}
