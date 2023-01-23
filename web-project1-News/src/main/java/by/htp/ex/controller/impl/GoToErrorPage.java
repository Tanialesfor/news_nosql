package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GoToErrorPage implements Command {

	private static final String ERROR_MESSAGE = "errorMessage";
//	private static final String PRESENTATION = "presentation";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String messageOfError = (String) session.getAttribute(ERROR_MESSAGE);

        if (messageOfError != null) {
        	request.getSession(true).setAttribute(ERROR_MESSAGE, messageOfError);
        }
           request.getRequestDispatcher("WEB-INF/pages/tiles/error.jsp").forward(request, response);
        
        // request.setAttribute(PRESENTATION, "error");
        // request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
           
      }
}

