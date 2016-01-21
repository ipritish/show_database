package main.java.com.datashow.datamodel;

import java.util.Vector;

public class AnimeData {
	
	private static Vector<Vector<Object>> animeData = new Vector<Vector<Object>>();

	public static Vector<Vector<Object>> getAnimeData() {
		return animeData;
	}

	public static void setAnimeData(Vector<Vector<Object>> animeData) {
		AnimeData.animeData = animeData;
	}
	

}
