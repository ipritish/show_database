package main.java.com.datashow.database;

import main.java.com.datashow.exceptions.UserNotFoundException;
import main.java.com.datashow.persistence.HibernateUtil;
import main.java.com.datashow.persistence.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserCRUD 
{
	public static void addUser(String userName, String password)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
		    
		User user = new User();  
		user.setUserName(userName);  
		user.setPassword(password);


		//saving objects to session  
		session.save(user);  
		//session.save(user2);  
		session.getTransaction().commit();  
		session.close(); 
	}
	
	public static User getUser(String userName) throws UserNotFoundException
	{
		try
		{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        	Session session = sessionFactory.openSession();  
        	session.beginTransaction();
        
        	
        	String queryString = "from user where username = :username";
        	Query query = session.createQuery(queryString);
        	query.setString("username", userName);
		
        	Object queryResult = query.uniqueResult();
        	User user = (User)queryResult;
        	return user;
		}
        catch(Exception ie)
		{
        	throw new UserNotFoundException();
		}
	}
}
