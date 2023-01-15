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

	private static final String NEWS_ID = "id";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = (HttpSession) request.getSession();
        //String role = (String) session.getAttribute(USER_ROLE);

           String[] newsId = request.getParameterValues(NEWS_ID);
            if (newsId != null) {
            	try {
            		service.delete(newsId);            	
            	} catch (ServiceException e) {
            		response.sendRedirect("/WEB-INF/pages/tiles/viewNews.jsp");
            	}
            		response.sendRedirect("controller?command=go_to_news_list");
            } else {
            	response.sendRedirect("/WEB-INF/pages/tiles/error.jsp");
            }     
	
//            try {
//                    service.delete(newsId);
//                } catch (ServiceException e) {
//                    session.setAttribute(ERROR_MESSAGE,"delete error");
//                    response.sendRedirect("controller?command=go_to_error_page");
//                }
//                response.sendRedirect("controller?command=go_to_news_list");
//            } else {
//            	session.setAttribute("AuthenticationError","no news to delete");
//            	session.setAttribute(ERROR_MESSAGE,"no news to delete selected");
//                response.sendRedirect("controller?command=go_to_error_page");
//               request.getRequestDispatcher("/WEB-INF/pages/tiles/error.jsp").forward(request, response);
//
//                response.sendRedirect("/WEB-INF/pages/tiles/error.jsp");
//            }
//        } else {
//            session.setAttribute(ERROR_MESSAGE,"user with such role cannot delete news");
//            response.sendRedirect("controller?command=go_to_error_page");
//        }
//	}
            
	}
}
