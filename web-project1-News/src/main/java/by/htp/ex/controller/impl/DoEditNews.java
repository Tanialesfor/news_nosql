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

public class DoEditNews implements Command {
	
	private final INewsService service = ServiceProvider.getInstance().getNewsService();

	private static final String NEWS_ID = "id";	

	public DoEditNews() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int newsId = Integer.parseInt(request.getParameter(NEWS_ID));
        
        News news = new News(newsId, request.getParameter("title"), request.getParameter("brief"), request.getParameter("content"), request.getParameter("date"));
        
    	try {
    		service.update(news);            	
    	} catch (ServiceException e) {
    		response.sendRedirect("/WEB-INF/pages/tiles/viewNews.jsp");
    	}
    		response.sendRedirect("controller?command=go_to_news_list");
    		
	}
}
