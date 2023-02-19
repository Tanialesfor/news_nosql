package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.INewsDAO;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.dao.impl.connectionpool.ConnectionPool;
import by.htp.ex.dao.impl.connectionpool.ConnectionPoolException;

public class NewsDAO implements INewsDAO {

	List<News> result = new ArrayList<News>();
	{
		result.add(new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "contect1", "11/11/22"));
		result.add(new News(2, "title2", "brief2brief2brief2brief2brief2brief2brief2", "contect2", "11/11/22"));
		result.add(new News(3, "title3", "brief3brief3brief3brief3brief3brief3brief3", "contect3", "11/11/22"));
		result.add(new News(4, "title4", "brief4brief4brief4brief4brief4brief4brief4", "contect4", "11/11/22"));
		result.add(new News(5, "title5", "brief5brief5brief5brief5brief5brief5brief5", "contect5", "11/11/22"));
	}

	private ConnectionPool pool = ConnectionPool.getConnectionPool();		
	
	@Override
	public List<News> getLatestsList(int count) throws NewsDAOException, SQLException, ConnectionPoolException {
		
		List<News> list = new ArrayList<News>();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		con = pool.takeConnection();     		
		st = con.createStatement();
		
		rs = st.executeQuery("SELECT * FROM news.news");		

		Integer i=0;
		while (rs.next()||i==5) {	        	
	        list.add(new News(rs.getInt("id"),rs.getString("title"),rs.getString("brief"),rs.getString("content"),rs.getDate("date_creation").toString()));
	        i++;
		}
		
//		while (rs.next()) {	        	
//	        list.add(new News(rs.getInt("id"),rs.getString("title"),rs.getString("brief"),rs.getString("content"),rs.getDate("date_creation").toString()));
//		}	
		
		pool.closeConnection(con, st, rs);		
		
		return list;
//		return list.size() < count ? list : list.subList(0, count);
	}

	@Override
	public List<News> getList() throws NewsDAOException, SQLException, ConnectionPoolException {
		List<News> list = new ArrayList<News>();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		con = pool.takeConnection();
		st = con.createStatement();

		rs = st.executeQuery("SELECT * FROM news.news");		

		while (rs.next()) {	        	
	        list.add(new News(rs.getInt("id"),rs.getString("title"),rs.getString("brief"),rs.getString("content"),rs.getDate("date_creation").toString()));
		}	
		
		pool.closeConnection(con, st, rs);	
		
		return list;		
		
//		return result;
	}

	@Override
	public News fetchById(int id) throws NewsDAOException {
		return result.stream().filter(o -> o.getIdNews().equals(id)).findFirst().orElse(null);
	}

	@Override
	public int addNews(News news) throws NewsDAOException {
		result.add(news);
		return 0;
	}

	@Override
	public void updateNews(News news) throws NewsDAOException {
		int indexDelete = -1;
		for (News element : result) {
			if (element.getIdNews().equals(news.getIdNews())) {
				indexDelete = result.indexOf(element);
			}
		}
		if (indexDelete >= 0) {
			result.set(indexDelete, news);
		}

	}

	@Override
	public void deleteNewses(String[] idNewses) throws NewsDAOException {
		int arrayNews[] = Arrays.stream(idNewses).mapToInt(Integer::parseInt).toArray();
		for (int i = result.size()-1; i > -1 ; i--) {
			News newsDelete = result.get(i);
			for (int j : arrayNews) {
				if (newsDelete.getIdNews() == j) {
					this.result.remove(newsDelete);
				}
			}
		}

	}

}
