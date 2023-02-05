package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.Role;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO implements IUserDAO {	
	
	
    List<Role> roleArray = new ArrayList<Role>();
    {
    	roleArray.add(new Role ("admin", true));
    	roleArray.add(new Role ("user", false));
    }	
     
	public Role getRole(String nameOfRole) {
		for (Role element : roleArray) {
			if (element.getNameofRole().equals(nameOfRole)) {
				return element;
			}			
		}
		return null;
	}
    
	public boolean isAdmin(Role role) {
		if (role.getAdminProperty()==true) {
			return true;
		} else {
			return false;
		}
	} 
	
    List<NewUserInfo> userArray = new ArrayList<NewUserInfo>();
	{
		userArray.add(new NewUserInfo ("Roman", "roman.2000@gmail.com","roman2000", "1112000", getRole("admin")));
		userArray.add(new NewUserInfo ("Anet", "anet.1990@gmail.com","anet1990", "2221990", getRole("user")));
		userArray.add(new NewUserInfo ("Vlad", "vlad.1995@gmail.com","vlad", "3331995", getRole("user")));
		userArray.add(new NewUserInfo ("Kate", "kate.1992@gmail.com","kate1992", "4441992", getRole("user")));
		userArray.add(new NewUserInfo ("Ula", "ula.1999@gmail.com","ula1999", "5551999", getRole("user")));
	 }  

	public NewUserInfo getUser(String login){					
		for (NewUserInfo element : userArray) {
			if (element.getLogin().equals(login)) {
				return element;
			}			
		}
		return null;		
	}
	
    @Override
 	public boolean logination(String login, String password) throws DaoException,  SQLException, ClassNotFoundException {
    	    	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = null;
		ResultSet rs = null;
		
		try {
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news?useSSL=false", "root", "123456");

		String sql = "SELECT password FROM users WHERE login = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, login);
		
		rs = ps.executeQuery();
		while (rs.next()) {
	        if (rs.getString("password").equals(password)) {
	        	return true;
	        }
		}

// 		for (NewUserInfo element : userArray) {
//			if (element.getLogin().equals(login)==true) {
//				if (element.getPassword().equals(password)==true) {
//					return true;
//				}
//			}			
//		}    	 
    	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
//			try {
//				if (st != null) {
//					st.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
    	return false;		
 	}
     
	@Override
	public boolean loginExist(String login) throws DaoException {
 		for (NewUserInfo element : userArray) {
			if (element.getLogin().equals(login)==true) {
				return true;
			}			
		}   		
		return false;
	}    
    
     	
	public String getRole(String login, String password) throws DaoException, SQLException, ClassNotFoundException {
			if (logination(login, password)==true) {
				return getUser(login).getRole().getNameofRole();
			}						
		return "guest";
	}
	
	public boolean isAdmin(String login, String password) throws DaoException, SQLException, ClassNotFoundException {
		if (logination(login, password)==true) {
			return getUser(login).getRole().getAdminProperty();
		}						
	return false;
	}	

	@Override
	public boolean registration(NewUserInfo user) throws DaoException, SQLException, ClassNotFoundException  {				
		if (loginExist(user.getLogin())==false) {
			user.setRole(getRole("user"));
			userArray.add(user);
			return true;
		}
		return false;
	}
}
