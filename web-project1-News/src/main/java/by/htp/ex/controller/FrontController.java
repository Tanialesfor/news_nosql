package by.htp.ex.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final CommandProvider provider = new CommandProvider();
       

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		functionCommand(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		functionCommand(request, response);
	}
	
	private void functionCommand (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String commandName = request.getParameter("command");
			Command command = provider.getCommand(commandName);
			command.execute(request, response);
		} catch (Exception e) {
		response.sendRedirect("controller?command=go_to_error_page");
			//request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);			
		}
	}

}
