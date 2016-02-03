package main.java.com.datashow.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import main.java.com.datashow.persistence.Anime;
import main.java.com.datashow.persistence.HibernateUtil;

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
        
        String queryString = "";
        Query queryResult;
        
        queryString = "from animes where associatedUser = :user";
        queryResult = session.createQuery(queryString);
        queryResult.setString("user", UserSessionDetails.getUserNameLoggedIn());

        
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
	
	public static void updateAnimeEntry(Anime anime)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
        
        session.update(anime);
        
        session.getTransaction().commit();  
		session.close(); 
	}
	
	public static Anime getSingleEntryFromName(String anime_name)
	{
		Anime anime = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
        Query query = session.createQuery("from animes where animeName=:name");
        query.setString("name", anime_name);
		@SuppressWarnings("unchecked")
		ArrayList<Anime> animeList = (ArrayList<Anime>) query.list(); 
		if (animeList.size() == 1)
		{
			anime = animeList.get(0);
		}
        
        return anime;
	}

}
