package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.util.validation.UserDataValidation;
import by.htp.ex.util.validation.ValidationProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command {

	private final IUserService service = ServiceProvider.getInstance().getUserService();
	private final UserDataValidation userDataValidation = ValidationProvider.getInstance().getUserDataValidation();

	private static final String JSP_NAME_PARAM = "name";
	private static final String JSP_EMAIL_PARAM = "email";
	private static final String JSP_LOGIN_PARAM = "login";
	private static final String JSP_PASSWORD_PARAM = "password";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String AUTHER_MESSAGE = "autherMessage";	
	private static final String AUTHER_ERROR = "AuthenticationError";
	private static final String PRESENTATION = "presentation";	
	
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
				
		if(userDataValidation.checkRegData(name, login, password, email)) {		
			try {
				NewUserInfo user= new NewUserInfo (name, email, login, password);
	    		if (service.registration(user)) {
	    		    request.getSession().setAttribute(AUTHER_MESSAGE, "registration completed successfully");
	    		    response.sendRedirect("controller?command=go_to_news_list");		    		    
	    		} else {
	    			request.setAttribute(AUTHER_ERROR, "user already exist");
	    			request.setAttribute(PRESENTATION, "registration");
	    			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);	  			
	    		}          	
			} catch (ServiceException e) {
	   		    request.getSession().setAttribute(ERROR_MESSAGE, e.getMessage());
	    		response.sendRedirect("controller?command=go_to_error_page");		
	    	}
		} else {
			request.setAttribute(AUTHER_ERROR, "input field invalid");
			request.setAttribute(PRESENTATION, "registration");
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);				
		}	
	}
}


