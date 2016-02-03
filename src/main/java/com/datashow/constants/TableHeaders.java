package main.java.com.datashow.constants;

import java.util.Vector;


public class TableHeaders {
	

	private static Vector<String> showColumns = new Vector<String>();
	private static Vector<String> animeColumns = new Vector<String>();
	public static final String TYPE_SHOW = "Show";
	public static final String TYPE_ANIME = "Anime";
	
	public static Vector<String> getShowColumns()
	{
		showColumns.removeAllElements();
		showColumns.add("Show Name");
		showColumns.add("IMDB Rating");
		showColumns.add("Current Season");
		showColumns.add("Is Airing");
		showColumns.add("Air Day");
		return showColumns;
	}
	
	public static Vector<String> getAnimeColumns()
	{
		animeColumns.removeAllElements();
		animeColumns.add("Anime Name");
		animeColumns.add("MAL Rating");
		animeColumns.add("Current Season");
		animeColumns.add("Is Airing");
		animeColumns.add("Air Day");
		return animeColumns;
	}

}
