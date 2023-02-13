package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.Role;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.impl.connectionpool.ConnectionPool;
import by.htp.ex.dao.impl.connectionpool.ConnectionPoolException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.ex.dao.impl.connectionpool.ConnectionPool;

public class UserDAO implements IUserDAO {	
	
	
//    List<Role> roleArray = new ArrayList<Role>();
//    {
//    	roleArray.add(new Role ("admin", true));
//    	roleArray.add(new Role ("user", false));
//    }	
     
//	public Role getRole(String nameOfRole) {
//		for (Role element : roleArray) {
//			if (element.getNameofRole().equals(nameOfRole)) {
//				return element;
//			}			
//		}
//		return null;
//	}
//    
//	public boolean isAdmin(Role role) {
//		if (role.getAdminProperty()==true) {
//			return true;
//		} else {
//			return false;
//		}
//	} 
	
//    List<NewUserInfo> userArray = new ArrayList<NewUserInfo>();
//	{
//		userArray.add(new NewUserInfo ("Roman", "roman.2000@gmail.com","roman2000", "1112000", getRole("admin")));
//		userArray.add(new NewUserInfo ("Anet", "anet.1990@gmail.com","anet1990", "2221990", getRole("user")));
//		userArray.add(new NewUserInfo ("Vlad", "vlad.1995@gmail.com","vlad", "3331995", getRole("user")));
//		userArray.add(new NewUserInfo ("Kate", "kate.1992@gmail.com","kate1992", "4441992", getRole("user")));
//		userArray.add(new NewUserInfo ("Ula", "ula.1999@gmail.com","ula1999", "5551999", getRole("user")));
//	 }  
	
	
	private ConnectionPool pool = ConnectionPool.getConnectionPool();		

//	public NewUserInfo getUser(String login){					
//		for (NewUserInfo element : userArray) {
//			if (element.getLogin().equals(login)) {
//				return element;
//			}			
//		}
//		return null;		
//	}
	
    @Override
 	public boolean logination(String login, String password) throws DaoException, ConnectionPoolException, SQLException {
    	    	
//		Class.forName("com.mysql.cj.jdbc.Driver");
    	
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		boolean success = false;
		
		//con = DriverManager.getConnection("jdb:cmysql://127.0.0.1/news?useSSL=false", "root", "123456");
			
		con = pool.takeConnection();     
		String sql = "SELECT password FROM users WHERE login = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, login);
		
		rs = ps.executeQuery();
		while (rs.next()) {
	        if (rs.getString("password").equals(password)) {	        	
	        	success = true;
	        }
		}
		
		pool.closeConnection(con, ps, rs);	
		
		if (success == true) {
			return true;
		}

// 		for (NewUserInfo element : userArray) {
//			if (element.getLogin().equals(login)==true) {
//				if (element.getPassword().equals(password)==true) {
//					return true;
//				}
//			}			
//		}    	 
		
    	return false;		
 	}
     
	@Override
	public boolean loginExist(String login) throws DaoException, ConnectionPoolException, SQLException {
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;		
		
		con = pool.takeConnection();     
		String sql = "SELECT password FROM users WHERE login = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, login);
		
		rs = ps.executeQuery();
		
		boolean success = false;
		
		if (rs.next()) {
			success = true;
		}
		
		pool.closeConnection(con, ps, rs);
		
		if (success == true) {
			return true;
		}
		
// 		for (NewUserInfo element : userArray) {
//			if (element.getLogin().equals(login)==true) {
//				return true;
//			}			
//		}					
		
		return false;
	}    
    
     	
	public String getRole(String login, String password) throws DaoException, ConnectionPoolException, SQLException {
		String nameRole = "guest";
		
		if (logination(login, password)==true) {
			Connection con = null;
			PreparedStatement ps=null;
			ResultSet rs = null;
			
			con = pool.takeConnection();     
			String sql = "SELECT role_name FROM news.roles INNER JOIN news.users ON news.roles.id=news.users.roles_id WHERE login = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, login);
			
			rs = ps.executeQuery();					
			
			if (rs.next()) {
				nameRole = rs.getString("role_name");
			}
			
			pool.closeConnection(con, ps, rs);
			
			if (nameRole != null) {
				return nameRole;
			}
			
		}		
		
		return nameRole;
	}
	
	public boolean isAdmin(String login, String password) throws DaoException, ConnectionPoolException, SQLException {
		if (logination(login, password)==true) {
			Connection con = null;
			PreparedStatement ps=null;
			ResultSet rs = null;
			
			con = pool.takeConnection();     
			String sql = "SELECT permission_name FROM news.permissions INNER JOIN news.role_has_permissions ON news.permissions.id=news.role_has_permissions.permissions_id \r\n"
					+ "INNER JOIN news.roles ON news.roles.id=news.role_has_permissions.roles_id \r\n"
					+ "INNER JOIN news.users ON news.roles.id=news.users.roles_id WHERE news.permissions.id='2' AND news.users.login=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, login);			
			
			rs = ps.executeQuery();					
			
			boolean success = false;
			
			if (rs.next()) {
				success = true;
			}
			
			pool.closeConnection(con, ps, rs);
			
			if (success = true) {
				return true;
			}

		}						
	return false;
	}	

	@Override
	public boolean registration(NewUserInfo user) throws DaoException, ConnectionPoolException, SQLException {				
		if (loginExist(user.getLogin())==false) {
//			user.setRole(getRole("user"));
			
			Connection con = null;
			PreparedStatement ps=null;
			ResultSet rs = null;
			
			con = pool.takeConnection();
			String sql = "INSERT INTO users(login, password, date_registration, roles_id, status_id) VALUES(?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			
			Date now = new Date();
			java.sql.Date date = new java.sql.Date(now.getTime());
			ps.setDate(3, date);
			ps.setString(4, "2");
			ps.setString(5, "1");

			boolean success = false;
			
			if (ps.executeUpdate()>=1) {
				success = true;	
			}
			
//			con = pool.takeConnection();
//			String sql2 = "INSERT INTO user-details(users_id, name, surname, birthday, email) VALUES(?, ?, ?, ?, ?)";
//			ps = con.prepareStatement(sql2);
//
//			ps.setString(1, user.getLogin());
//			ps.setString(2, user.getUserName());
//			ps.setString(3, user.getUserSurname());
//			ps.setString(4, user.getBirthday());
//			ps.setString(5, user.getEmail());

//			boolean success = false;
			
						
			pool.closeConnection(con, ps, rs);
			
			if (success == true) {
				return true;
			}
			
//			userArray.add(user);
		}
		return false;
	}
}
