package by.htp.ex.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.Role;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDAO;

public class UserDAO implements IUserDAO{

     List<NewUserInfo> userArray = new ArrayList<NewUserInfo>();
     {
    	userArray.add(new NewUserInfo ("Roman", "roman.2000@gmail.com","roman2000", "1112000"));
    	userArray.add(new NewUserInfo ("Anet", "anet.1990@gmail.com","anet1990", "2221990"));
    	userArray.add(new NewUserInfo ("Vlad", "vlad.1995@gmail.com","vlad", "3331995"));
    	userArray.add(new NewUserInfo ("Kate", "kate.1992@gmail.com","kate1992", "4441992"));
     }  
     
     List<NewUserInfo> userArrayFull = new ArrayList<NewUserInfo>();
     {
    	userArrayFull.add(new NewUserInfo ("Roman", "roman.2000@gmail.com","roman2000", "1112000", new Role("admin",true)));
    	userArrayFull.add(new NewUserInfo ("Anet", "anet.1990@gmail.com","anet1990", "2221990", new Role("admin",false)));
    	userArrayFull.add(new NewUserInfo ("Vlad", "vlad.1995@gmail.com","vlad", "3331995", new Role("admin",false)));
    	userArrayFull.add(new NewUserInfo ("Kate", "kate.1992@gmail.com","kate1992", "4441992", new Role("admin",false)));
     }  
    
     @Override
 	public boolean logination(String login, String password) throws DaoException {
 		// TODO Auto-generated method stub
    	 /*
 		 * Random rand = new Random(); int value = rand.nextInt(1000);
 		 * 
 		 * if(value % 3 == 0) { try { throw new SQLException("stub exception");
 		 * }catch(SQLException e) { throw new DaoException(e); } }else if (value % 2 ==
 		 * 0) { return true; }else { return false; }
 		 */
//    	 if (userArray.stream().filter(user -> user.getLogin().equals(login)&&user.getPassword().equals(password).))
    	 
 		return true;
 	}
     
     	
	public String getRole(String login, String password) {
		return "admin";
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException  {
		// TODO Auto-generated method stub
		return false;
	}

	

}
