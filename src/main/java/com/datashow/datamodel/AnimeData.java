package main.java.com.datashow.datamodel;

import java.util.ArrayList;
import java.util.Vector;

import main.java.com.datashow.persistence.Anime;

public class AnimeData {
	

	private static ArrayList<Anime> animeData = new ArrayList<Anime>();

	public static ArrayList<Anime> getAnimeData() {
		return animeData;
	}

	public static void setAnimeData(ArrayList<Anime> animeData) {
		AnimeData.animeData = animeData;
	}
	
	public static Vector<Vector<Object>> getVectorFromListData()
	{
		Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();
		for (Anime singleAnime : getAnimeData())
		{
			Vector<Object> singleRow = new Vector<Object>();
			singleRow.addElement(singleAnime.getAnimeName());
			singleRow.addElement(singleAnime.getRating());
			singleRow.addElement(singleAnime.getSeason());
			singleRow.addElement(singleAnime.isAiring());
			singleRow.addElement(singleAnime.getAirDay());
			
			tableData.addElement(singleRow);
		}
		
		return tableData;
	}
	

}
