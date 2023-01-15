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

public class DoAddNews implements Command {
		
	private final INewsService service = ServiceProvider.getInstance().getNewsService();

	private static final String NEWS_ID = "id";		

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        int newsId = Integer.parseInt(request.getParameter(NEWS_ID));
        
        News news = new News(newsId, request.getParameter("title"), request.getParameter("brief"), request.getParameter("content"), request.getParameter("date"));
//        News news = new News(newsId, "title", "brief", "content", "date");        
        
    	try {
    		service.add(news);            	
    	} catch (ServiceException e) {
    		response.sendRedirect("controller?command=go_to_error_page");
    	}
    		response.sendRedirect("controller?command=go_to_news_list");
	}

}
