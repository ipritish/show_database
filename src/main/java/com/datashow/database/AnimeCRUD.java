package main.java.com.datashow.database;

import java.util.ArrayList;
import java.util.Vector;

import main.java.com.datashow.persistence.Anime;
import main.java.com.datashow.persistence.HibernateUtil;
import main.java.com.datashow.persistence.Show;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AnimeCRUD 
{
	public static void addAnime(String animeName, double rating, int season, 
			boolean isAiring, String airDay, String associatedUser)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
		    
		Anime anime = new Anime();  
		anime.setAnimeName(animeName);
		anime.setRating(rating);
		anime.setSeason(season);
		anime.setAiring(isAiring);
		anime.setAirDay(airDay);
		anime.setAssociatedUser(associatedUser);
		//saving objects to session  
		session.save(anime);  
		//session.save(user2);  
		session.getTransaction().commit();  
		session.close(); 
	}
	
	@SuppressWarnings("unchecked")
	public static Vector<Vector<Object>> getAllAnimes()
	{
		Vector<Vector<Object>> allData = new Vector<Vector<Object>>();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
        
        ArrayList<Anime> allShows = new ArrayList<Anime>();
        
        Query queryResult = session.createQuery("from animes");
        allShows = (ArrayList<Anime>) queryResult.list();
        
        for(int i=0; i<allShows.size();i++)
        {
        	Anime singleAnime = (Anime) allShows.get(i);
        	Vector<Object> rowData = new Vector<Object>();
        	rowData.addElement(singleAnime.getAnimeName());
        	rowData.addElement(singleAnime.getRating());
        	rowData.addElement(singleAnime.getSeason());
        	rowData.addElement(singleAnime.isAiring());
        	rowData.addElement(singleAnime.getAirDay());
        	allData.addElement(rowData);
        }
		 return allData;
	}

}
