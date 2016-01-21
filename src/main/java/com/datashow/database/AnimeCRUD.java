package main.java.com.datashow.database;

import main.java.com.datashow.persistence.Anime;
import main.java.com.datashow.persistence.HibernateUtil;
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

}
