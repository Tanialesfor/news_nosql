package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToEditNews implements Command {
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	
	private static final String JSP_NEWS_ID = "id";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		News news;

		String id;

		id = request.getParameter(JSP_NEWS_ID);

		try {
			news = newsService.findById(Integer.parseInt(id));
			request.setAttribute("news", news);
			request.setAttribute("presentation", "editNews");

			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect("controller?command=go_to_error_page");
		}
	}

	}


