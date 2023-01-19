package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command {

	private final IUserService service = ServiceProvider.getInstance().getUserService();

	private static final String JSP_NAME_PARAM = "name";
	private static final String JSP_EMAIL_PARAM = "email";
	private static final String JSP_LOGIN_PARAM = "login";
	private static final String JSP_PASSWORD_PARAM = "password";
	private static final String AUTHER_ERROR = "AuthenticationError";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name;
		String email;
		String login;
		String password;

		name = request.getParameter(JSP_NAME_PARAM);
		email = request.getParameter(JSP_EMAIL_PARAM);
		login = request.getParameter(JSP_LOGIN_PARAM);
		password = request.getParameter(JSP_PASSWORD_PARAM);
		NewUserInfo user= new NewUserInfo (name, email, login, password);
		
		try {
    		service.registration(user);   
       	} catch (ServiceException e) {
    		request.setAttribute(AUTHER_ERROR, "registration error");
    		response.sendRedirect("controller?command=go_to_error_page");
    	}
		    request.setAttribute(AUTHER_ERROR, "registration completed successfully");
		    response.sendRedirect("controller?command=go_to_news_list");
	}
}


