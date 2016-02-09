package main.java.com.datashow.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import main.java.com.datashow.datamodel.AnimeData;
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
	public static ArrayList<Anime> getAllAnimes()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
        
        ArrayList<Anime> allAnimes = new ArrayList<Anime>();
        
        String queryString = "";
        Query queryResult;
        
        queryString = "from animes where associatedUser = :user";
        queryResult = session.createQuery(queryString);
        queryResult.setString("user", UserSessionDetails.getUserNameLoggedIn());

        
        allAnimes = (ArrayList<Anime>) queryResult.list();
		
        return allAnimes;
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
