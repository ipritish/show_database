package main.java.com.datashow.database;

import main.java.com.datashow.persistence.HibernateUtil;
import main.java.com.datashow.persistence.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddUser 
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
}
