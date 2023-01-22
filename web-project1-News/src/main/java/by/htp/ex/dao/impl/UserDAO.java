package by.htp.ex.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.Role;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;

public class UserDAO implements IUserDAO{
	
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

	public NewUserInfo getUser(String login) {
		for (NewUserInfo element : userArray) {
			if (element.getLogin().equals(login)) {
				return element;
			}			
		}
		return null;		
	}
	
    @Override
 	public boolean logination(String login, String password) throws DaoException {
 		// TODO Auto-generated method 
    	 /*
 		 * Random rand = new Random(); int value = rand.nextInt(1000);
 		 * 
 		 * if(value % 3 == 0) { try { throw new SQLException("stub exception");
 		 * }catch(SQLException e) { throw new DaoException(e); } }else if (value % 2 ==
 		 * 0) { return true; }else { return false; }
 		 */

 		for (NewUserInfo element : userArray) {
			if (element.getLogin().equals(login)==true) {
				if (element.getPassword().equals(password)==true) {
					return true;
				}
			}			
		}    	 
    	return false;
 	}
     
     	
	public String getRole(String login, String password) throws DaoException {
			if (logination(login, password)==true) {
				return getUser(login).getRole().getNameofRole();
			}						
		return "guest";
	}
	
	public boolean isAdmin(String login, String password) throws DaoException {
		if (logination(login, password)==true) {
			return getUser(login).getRole().getAdminProperty();
		}						
	return false;
	}	

	@Override
	public boolean registration(NewUserInfo user) throws DaoException  {				
		if (logination(user.getLogin(), user.getPassword())==false) {
			user.setRole(getRole("user"));
			userArray.add(user);
			return true;
		}
		return false;
	}

	

}
