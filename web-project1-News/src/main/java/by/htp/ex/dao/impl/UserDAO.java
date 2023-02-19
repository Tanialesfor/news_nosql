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
import by.htp.ex.service.ServiceException;

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
	
	private static final String SELECT_PASSWORD_FROM_LOGIN = "SELECT password FROM users WHERE login = ?";
	private static final String SELECT_ID_FROM_LOGIN = "SELECT id FROM users WHERE login = ?";
	private static final String SELECT_ROLE_NAME_FROM_LOGIN = "SELECT role_name FROM news.roles INNER JOIN news.users ON news.roles.id=news.users.roles_id WHERE login = ?";
	private static final String SELECT_PERMISSION_NAME_FROM_PREMID_LOGIN = "SELECT permission_name FROM news.permissions INNER JOIN news.role_has_permissions ON news.permissions.id=news.role_has_permissions.permissions_id \r\n"
	+ "INNER JOIN news.roles ON news.roles.id=news.role_has_permissions.roles_id \r\n"
	+ "INNER JOIN news.users ON news.roles.id=news.users.roles_id WHERE news.permissions.id='2' AND news.users.login=?";
	private static final String INSERT_USERS = "INSERT INTO users(login, password, date_registration, roles_id, status_id) VALUES(?, ?, ?, ?, ?)";
	private static final String INSERT_USERS_DETAILS = "INSERT INTO user_details(users_id, name, surname, birthday, email) VALUES(?, ?, ?, ?, ?)";
	
	private ConnectionPool pool = ConnectionPool.getConnectionPool();		
	
    @Override
 	public boolean logination(String login, String password) throws DaoException {
    	        	
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		boolean success = false;
		
		try {	
			con = pool.takeConnection();     
			ps = con.prepareStatement(SELECT_PASSWORD_FROM_LOGIN);
			ps.setString(1, login);
			
			rs = ps.executeQuery();
			while (rs.next()) {
		        if (rs.getString("password").equals(password)) {	        	
		        	success = true;
		        }
			}
			
			if (success == true) {
				return true;
			}		
		}
    	catch (SQLException e) {
			throw new DaoException("error select login in news.users from method logination", e);
		}
		catch (ConnectionPoolException e) {
			throw new DaoException("problem with connection pool", e);		
        } 
		finally {
			pool.closeConnection(con, ps, rs);
	   }
		
		return false;
    }
     
	@Override
	public boolean loginExist(String login) throws DaoException {
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;		
		try {
			con = pool.takeConnection();     
			ps = con.prepareStatement(SELECT_PASSWORD_FROM_LOGIN);
			ps.setString(1, login);
			
			rs = ps.executeQuery();
			
			boolean success = false;
			
			if (rs.next()) {
				success = true;
			}
					
			if (success == true) {
				return true;
			}					
		}
		catch (SQLException e) {
			throw new DaoException("error select login in news.users from method loginExist", e);
		}
		catch (ConnectionPoolException e) {
			throw new DaoException("problem with connection pool", e);
		}
		finally {
			pool.closeConnection(con, ps, rs);
		}
		
		return false;		
	}    
    
     	
	public String getRole(String login, String password) throws DaoException {
		String nameRole = "guest";
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		try {
			if (logination(login, password)==true) {			
				con = pool.takeConnection();     
				ps = con.prepareStatement(SELECT_ROLE_NAME_FROM_LOGIN);
				ps.setString(1, login);
				
				rs = ps.executeQuery();					
				
				if (rs.next()) {
					nameRole = rs.getString("role_name");
				}
			
				if (nameRole != null) {
					return nameRole;
				}			
			}		
		}
		catch (SQLException e) {
			throw new DaoException("error select role_name in tables users, role  from method getRole", e);
		}
		catch (ConnectionPoolException e) {
			throw new DaoException("problem with connection pool", e);
		} 
		finally {
			pool.closeConnection(con, ps, rs);
		}
	return nameRole;
}
	
	public boolean isAdmin(String login, String password) throws DaoException {
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		try{
			if (logination(login, password)==true) {						
				con = pool.takeConnection();     
				ps = con.prepareStatement(SELECT_PERMISSION_NAME_FROM_PREMID_LOGIN);
				ps.setString(1, login);			
				
				rs = ps.executeQuery();					
				
				boolean success = false;
				
				if (rs.next()) {
					success = true;
				}
					
				if (success == true) {
					return true;
				}
			}
		}
		catch (SQLException e) {
			throw new DaoException("error select permission_name in tables users, role, permission from method isAdmin", e);
		}
		catch (ConnectionPoolException e) {
			throw new DaoException("problem with connection pool", e);
		} 
		finally {
			pool.closeConnection(con, ps, rs);
		}
	return false;			
	}	

	@Override
	public boolean registration(NewUserInfo user) throws DaoException {				
		Connection con = null;
		PreparedStatement ps=null;
						
		if (loginExist(user.getLogin())==false) {
			try  {	
				con = pool.takeConnection();
				con.setAutoCommit(false);
				ps = con.prepareStatement(INSERT_USERS);
	
				ps.setString(1, user.getLogin());
				ps.setString(2, user.getPassword());
				Date now = new Date();
				java.sql.Date date = new java.sql.Date(now.getTime());
				ps.setDate(3, date);
				ps.setString(4, "2");
				ps.setString(5, "1");
	
				boolean success = false;
				int user_id=-1;
				
				con.commit();
				
				if (ps.executeUpdate()>=1) {	
					try {
						PreparedStatement ps2 = con.prepareStatement(SELECT_ID_FROM_LOGIN);
						ps2.setString(1, user.getLogin());					
						ResultSet rs = ps2.executeQuery();
						
						while (rs.next()) {
							user_id = rs.getInt("id");
							success = true;	
						}
						
						ps2.close();
						rs.close();
					}
					catch (SQLException e) {
						throw new DaoException(e);
					}
				}
				else con.rollback();
				
				if (success = true) {
					success = false;
					PreparedStatement ps3 = con.prepareStatement(INSERT_USERS_DETAILS);
					ps3.setInt(1, user_id);
					ps3.setString(2, user.getUserName());
					ps3.setString(3, user.getUserSurname());
					ps3.setString(4, user.getBirthday());
					ps3.setString(5, user.getEmail());
					
					if (ps3.executeUpdate()>=1) {
						con.commit();
						ps3.close();
						success = true;	
					}
					else con.rollback();
				} 
			 
					if (success == true) {
					return true;
				}
			
			}
			catch (SQLException e) {
				throw new DaoException("error insert user in tables users, user_details from method registration",e);
			}
			catch (ConnectionPoolException e) {
				throw new DaoException("problem with connection pool", e);
			}
			finally {
				pool.closeConnection(con, ps);
			}
		}
		return false;
	}
}
