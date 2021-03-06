package main.java.com.datashow.database;

import java.util.ArrayList;
import java.util.Vector;

import main.java.com.datashow.datamodel.ShowData;
import main.java.com.datashow.persistence.Anime;
import main.java.com.datashow.persistence.HibernateUtil;
import main.java.com.datashow.persistence.Show;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ShowCRUD 
{
	public static void addShow(String showName, double rating, int season, 
			boolean isAiring, String airDay, String associatedUser)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
		    
		Show show = new Show();  
		show.setShowName(showName);
		show.setRating(rating);
		show.setSeason(season);
		show.setAiring(isAiring);
		show.setAirDay(airDay);
		show.setAssociatedUser(associatedUser);
		//saving objects to session  
		session.save(show);  
		//session.save(user2);  
		session.getTransaction().commit();  
		session.close(); 
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Show> getAllShows()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
        
        ArrayList<Show> allShows = new ArrayList<Show>();
        
        String queryString = "";
        Query queryResult;
        
        queryString = "from shows where associatedUser = :user";
        queryResult = session.createQuery(queryString);
        queryResult.setString("user", UserSessionDetails.getUserNameLoggedIn());
          
        
        allShows = (ArrayList<Show>) queryResult.list();
        return allShows;
	}
	
	public static void updateShowEntry(Show show)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
        
        session.update(show);
        
        session.getTransaction().commit();  
		session.close(); 
        
	}
	
	public static Show getSingleEntryFromName(String show_name)
	{
		Show show = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
        Query query = session.createQuery("from shows where showName=:name");
        query.setString("name", show_name);
		@SuppressWarnings("unchecked")
		ArrayList<Show> showList = (ArrayList<Show>) query.list(); 
		if (showList.size() == 1)
		{
			show = showList.get(0);
		}
        
        return show;
	}
}
