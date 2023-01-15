package by.htp.ex.service;

import java.util.List;

import by.htp.ex.bean.News;

public interface INewsService {
 
  
  List<News> latestList(int count)  throws ServiceException;
  List<News> list()  throws ServiceException;
  News findById(int id) throws ServiceException;
  void update(News news) throws ServiceException;
  void delete(String [] idNews) throws ServiceException;
  void save(News news) throws ServiceException;
  void find() throws ServiceException ;
}
