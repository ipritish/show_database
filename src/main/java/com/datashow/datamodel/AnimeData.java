package main.java.com.datashow.datamodel;

import java.util.ArrayList;
import java.util.Vector;

import main.java.com.datashow.persistence.Anime;

public class AnimeData {
	
	private static Vector<Vector<Object>> animeTableData = new Vector<Vector<Object>>();
	
	private static ArrayList<Anime> animeData = new ArrayList<Anime>();

	public static Vector<Vector<Object>> getAnimeTableData() {
		return animeTableData;
	}

	public static void setAnimeTableData(Vector<Vector<Object>> animeData) {
		AnimeData.animeTableData = animeData;
	}

	public static ArrayList<Anime> getAnimeData() {
		return animeData;
	}

	public static void setAnimeData(ArrayList<Anime> animeData) {
		AnimeData.animeData = animeData;
	}
	

}
