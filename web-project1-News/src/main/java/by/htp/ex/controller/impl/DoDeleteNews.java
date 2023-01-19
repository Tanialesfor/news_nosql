package by.htp.ex.controller.impl;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.service.impl.NewsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoDeleteNews implements Command {

	private final INewsService service = ServiceProvider.getInstance().getNewsService();

	private static final String JSP_NEWS_ID = "id";
	private static final String AUTHER_ERROR = "AuthenticationError";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession();
        //String role = (String) session.getAttribute(USER_ROLE);

           String[] newsId = request.getParameterValues(JSP_NEWS_ID);
            if (newsId != null) {
            	try {
            		service.delete(newsId);            	
            	} catch (ServiceException e) {
            		session.setAttribute(AUTHER_ERROR,"command delete error");
            		response.sendRedirect("/WEB-INF/pages/tiles/error.jsp");
//            		response.sendRedirect("/WEB-INF/pages/tiles/viewNews.jsp");
            	}
            		response.sendRedirect("controller?command=go_to_news_list");
            } else {
            	response.sendRedirect("/WEB-INF/pages/tiles/error.jsp");
            }     
	
            
	}
}
