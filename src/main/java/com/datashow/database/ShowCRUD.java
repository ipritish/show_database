package main.java.com.datashow.database;

import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;

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
	public static Vector<Vector<Object>> getAllShows()
	{
		Vector<Vector<Object>> allData = new Vector<Vector<Object>>();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
        
        ArrayList<Show> allShows = new ArrayList<Show>();
        
        String queryString = "";
        Query queryResult;
        
        if(UserSessionDetails.getUserNameLoggedIn().equals("admin"))
        {
        	queryString = "from shows";
        	queryResult = session.createQuery(queryString);
        }
        else
        {
        	queryString = "from shows where associatedUser = :user";
        	queryResult = session.createQuery(queryString);
            queryResult.setString("user", UserSessionDetails.getUserNameLoggedIn());
        }  
        
        allShows = (ArrayList<Show>) queryResult.list();
        
        for(int i=0; i<allShows.size();i++)
        {
        	Show singleShow = (Show) allShows.get(i);
        	Vector<Object> rowData = new Vector<Object>();
        	rowData.addElement(singleShow.getShowName());
        	rowData.addElement(singleShow.getRating());
        	rowData.addElement(singleShow.getSeason());
        	rowData.addElement(singleShow.isAiring());
        	rowData.addElement(singleShow.getAirDay());
        	allData.addElement(rowData);
        }
		 return allData;
	}
}
