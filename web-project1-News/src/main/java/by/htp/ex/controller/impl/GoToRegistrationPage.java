package by.htp.ex.controller.impl;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import by.htp.ex.controller.Command;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToRegistrationPage implements Command {

	private static final String PRESENTATION = "presentation";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute(PRESENTATION, "registration");
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (IOException e) {
			response.sendRedirect("controller?command=go_to_error_page");
		}
	}

}

