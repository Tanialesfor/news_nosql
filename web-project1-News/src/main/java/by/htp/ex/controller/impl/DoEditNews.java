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
import jakarta.servlet.http.HttpSession;

public class DoEditNews implements Command {
	
	private final INewsService service = ServiceProvider.getInstance().getNewsService();

	private static final String JSP_NEWS_ID = "id";	
	private static final String AUTHER_MESSAGE = "autherMessage";
	private static final String ERROR_MESSAGE = "errorMessage";

	public DoEditNews() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession();
        int newsId = Integer.parseInt(request.getParameter(JSP_NEWS_ID));
        
        News news = new News(newsId, request.getParameter("title"), request.getParameter("brief"), request.getParameter("content"), request.getParameter("date"));
        
    	try {
    		service.update(news);            	
    	} catch (ServiceException e) {
    		session.setAttribute(ERROR_MESSAGE,"command update error");
    		response.sendRedirect("controller?command=go_to_error_page");
    	}
    	    request.setAttribute(AUTHER_MESSAGE, "news edited successfully");
    	    response.sendRedirect("controller?command=go_to_news_list");
    		
	}
}
