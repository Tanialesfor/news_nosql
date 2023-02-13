package by.htp.ex.dao;

import java.sql.SQLException;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.impl.connectionpool.ConnectionPoolException;

public interface INewsDAO {
	List<News> getList() throws NewsDAOException, SQLException, ConnectionPoolException;
	List<News> getLatestsList(int count) throws NewsDAOException, SQLException, ConnectionPoolException;
	News fetchById(int id) throws NewsDAOException;
	int addNews(News news) throws NewsDAOException;
	void updateNews(News news) throws NewsDAOException;
	void deleteNewses(String[] idNewses)throws NewsDAOException;
}
