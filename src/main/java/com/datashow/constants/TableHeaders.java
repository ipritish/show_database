package main.java.com.datashow.constants;

import java.util.Vector;


public class TableHeaders {
	

	public static Vector<String> showColumns = new Vector<String>();
	public static Vector<String> animeColumns = new Vector<String>();
	
	public static Vector<Vector<Object>> placeHolderAnimeRowsData = new Vector<Vector<Object>>();
	public static Vector<Vector<Object>> placeHolderShowRowsData = new Vector<Vector<Object>>();
	
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
	
	public static Vector<Vector<Object>> getPlaceHolderShowData()
	{
		placeHolderAnimeRowsData.removeAllElements();
		Vector<Object> firstRowData = new Vector<Object>();
		firstRowData.addElement("Unbrekable Kimmi Schimdt");
		firstRowData.addElement(new Double(8.0));
		firstRowData.addElement(new Integer(2));
		firstRowData.addElement(new Boolean(false));
		firstRowData.addElement("Sunday");
		
		Vector<Object> secondRowData = new Vector<Object>();
		secondRowData.addElement("Archer");
		secondRowData.addElement(new Double(8.9));
		secondRowData.addElement(new Integer(7));
		secondRowData.addElement(new Boolean(false));
		secondRowData.addElement("Sunday");
		
		placeHolderAnimeRowsData.addElement(firstRowData);
		placeHolderAnimeRowsData.addElement(secondRowData);
		
		return placeHolderAnimeRowsData;
	}
	
	public static Vector<Vector<Object>> getPlaceHolderAnimeData()
	{
		placeHolderAnimeRowsData.removeAllElements();
		Vector<Object> firstRowData = new Vector<Object>();
		firstRowData.addElement("Naruto");
		firstRowData.addElement(new Double(8.0));
		firstRowData.addElement(new Integer(2));
		firstRowData.addElement(new Boolean(true));
		firstRowData.addElement("Thursday");
		
		placeHolderAnimeRowsData.addElement(firstRowData);
		return placeHolderAnimeRowsData;
	}

}
